$(document).ready(function() {
					// INI -- PARA JPA REPOSITORY
					$.ajax({
						type : "GET",
						url : "http://localhost:8080/persona/listar",
						contentType : "application/json; charset=utf-8",
						dataType : "json",
						success : function(models) {
							for (var i = 0; i < models.length; i++) {
								var valor = models[i].idPersona;
								var Descripcion = models[i].nombreCompleto;
								var dllLocal = $('[id$=cboPersona');
								dllLocal.append($("<option></option>").val(
										valor).html(Descripcion));
							}
						},

						error : function(XMLHttpRequest, textStatus,
								errorThrown) {
							alert("Request: " + XMLHttpRequest.toString()
									+ "\n\nStatus: " + textStatus
									+ "\n\nError: " + errorThrown);
						}
					});
					// FIN -- PARA JPA REPOSITORY

					$("#sortable").sortable();
					$("#sortable").disableSelection();

					countTodos();

					// all done btn
					$("#checkAll").click(function() {
						
						var arreglo = [];

						$('#sortable li').each(function() {
							var texto = $(this).text().trim();
							arreglo.push(texto);
						});
						
						callAjax(arreglo, 1);

						AllDone();

					});

					// create todo
					$('.add-todo').on('keypress', function(e) {
						e.preventDefault
						if (e.which == 13) {
							if ($(this).val() != '') {
								var todo = $(this).val();
								createTodo(todo);
								countTodos();
							} else {
								// some validation
							}
						}
					});
					// mark task as done
					$('.todolist').on(
							'change',
							'#sortable li input[type="checkbox"]',
							function() {
								if ($(this).prop('checked')) {
									var doneItem = $(this).parent().parent()
											.find('label').text();
									$(this).parent().parent().parent()
											.addClass('remove');

									var arreglo = [];
									arreglo.push(doneItem);

									callAjax(arreglo, 1);
									done(doneItem);
									countTodos();
								}
							});

					// delete done task from "already done"
					$('.todolist').on('click', '.remove-item', function() {
						removeItem(this);
					});

					// count tasks
					function countTodos() {
						var count = $("#sortable li").length;
						$('.count-todos').html(count);
					}

					// create task
					function createTodo(text) {
						var markup = '<li class="ui-state-default"><div class="checkbox"><label><input type="checkbox" value="" />'
								+ text + '</label></div></li>';
						$('#sortable').append(markup);
						$('.add-todo').val('');
					}

					// mark task as done
					function done(doneItem) {
						var done = doneItem;
						var markup = '<li>'
								+ done
								+ '<button class="btn btn-default btn-xs pull-right  remove-item"><span class="glyphicon glyphicon-remove"></span></button></li>';
						$('#done-items').append(markup);
						$('.remove').remove();
					}

					// mark all tasks as done
					function AllDone() {
						var myArray = [];

						$('#sortable li').each(function() {
							myArray.push($(this).text());
						});

						// add to done
						for (i = 0; i < myArray.length; i++) {
							$('#done-items')
									.append(
											'<li>'
													+ myArray[i]
													+ '<button class="btn btn-default btn-xs pull-right  remove-item"><span class="glyphicon glyphicon-remove"></span></button></li>');
						}

						// myArray
						$('#sortable li').remove();
						countTodos();
					}

					// remove done task from list
					function removeItem(element) {
						$(element).parent().remove();
					}

					function callAjax(arrTexto, estado) {
						// INI JPA REPOSITORY						
						var idPersona = $("#cboPersona").val();

						var notas = [];
						var estado = estado;

						// Recorrer arreglo y asociarlo al push
						for (var i = 0; i < arrTexto.length; i++) {
							var texto = arrTexto[i];
							notas.push({
								"texto" : texto,
								"estado" : estado
							});
						}
						// FIN Creando el JSON

						//Creara una nueva libreta y sus notas por cada petición
						var data = {
							"persona" : {
								"idPersona" : idPersona
							},
							"fecha" : "04/06/2017", //fecha ejemplo
							"notas" : notas
						};						
						
						var token = $('#csrfToken').val();
						var header = $('#csrfHeader').val();
									
						console.log(JSON.stringify(data));
						
						$.ajax({
							type : "POST",
							url : "http://localhost:8080/libreta/registrar",							
							data : JSON.stringify(data),
							async : true,
						    beforeSend: function(xhr) {
						        xhr.setRequestHeader("Accept", "application/json");
						        xhr.setRequestHeader("Content-Type", "application/json");
						        xhr.setRequestHeader(header, token);
						    },
							success : function(models) {
								// exito
							},
							error : function(XMLHttpRequest, textStatus,
									errorThrown) {
								alert("Request: " + XMLHttpRequest.toString()
										+ "\n\nStatus: " + textStatus
										+ "\n\nError: " + errorThrown);
							}
						});
						// FIN JPA REPOSITORY
					}

				});