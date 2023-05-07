//Usuarios

db.createCollection("Usuarios", {
   validator: {
      $jsonSchema: {
         bsonType: "object",
         required: ["identificacion", "perfil", "preferencias", "transacciones", "ubicacion"],
         properties: {
            identificacion: {
               bsonType: "string",
               description: "Identificación del usuario (ej. número de cédula)"
            },
            perfil: {
               bsonType: "object",
               required: ["nombre", "apellido", "correo", "telefono"],
               properties: {
                  nombre: {
                     bsonType: "string",
                     description: "Nombre del usuario"
                  },
                  apellido: {
                     bsonType: "string",
                     description: "Apellido del usuario"
                  },
                  correo: {
                     bsonType: "string",
                     description: "Correo electrónico del usuario"
                  },
                  telefono: {
                     bsonType: "string",
                     description: "Número de teléfono del usuario"
                  },
                  // Otros campos de perfil del usuario
               }
            },
            preferencias: {
               bsonType: "object",
               description: "Preferencias de servicios del usuario"
               // Campos de preferencias de servicios del usuario
            },
            transacciones: {
               bsonType: "array",
               description: "Historial de transacciones del usuario",
               items: {
                  bsonType: "object",
                  required: ["fecha", "monto", "descripcion"],
                  properties: {
                     fecha: {
                        bsonType: "date",
                        description: "Fecha de la transacción"
                     },
                     monto: {
                        bsonType: "number",
                        description: "Monto de la transacción"
                     },
                     descripcion: {
                        bsonType: "string",
                        description: "Descripción de la transacción"
                     }
                     // Otros campos de transacción
                  }
               }
            },
            ubicacion: {
               bsonType: "object",
               required: ["direccion", "ciudad", "pais"],
               properties: {
                  direccion: {
                     bsonType: "string",
                     description: "Dirección del usuario"
                  },
                  ciudad: {
                     bsonType: "string",
                     description: "Ciudad del usuario"
                  },
                  pais: {
                     bsonType: "string",
                     description: "País del usuario"
                  }
               }
            }
         }
      }
   }
})

// Servicios

db.createCollection("Servicios", {
   validator: {
      $jsonSchema: {
         bsonType: "object",
         required: ["nombre", "descripcion", "categoria", "precio", "opcionesPago", "ubicacion", "proveedor"],
         properties: {
            nombre: {
               bsonType: "string",
               description: "Nombre del servicio"
            },
            descripcion: {
               bsonType: "string",
               description: "Descripción del servicio"
            },
            categoria: {
               bsonType: "string",
               description: "Categoría del servicio"
            },
            precio: {
               bsonType: "number",
               description: "Precio del servicio"
            },
            opcionesPago: {
               bsonType: "array",
               description: "Opciones de pago del servicio",
               items: {
                  bsonType: "string",
                  description: "Opción de pago"
               }
            },
            ubicacion: {
               bsonType: "object",
               required: ["direccion", "ciudad", "pais"],
               properties: {
                  direccion: {
                     bsonType: "string",
                     description: "Dirección del servicio"
                  },
                  ciudad: {
                     bsonType: "string",
                     description: "Ciudad del servicio"
                  },
                  pais: {
                     bsonType: "string",
                     description: "País del servicio"
                  }
               }
            },
            proveedor: {
               bsonType: "object",
               required: ["nombre", "correo", "telefono"],
               properties: {
                  nombre: {
                     bsonType: "string",
                     description: "Nombre del proveedor del servicio"
                  },
                  correo: {
                     bsonType: "string",
                     description: "Correo electrónico del proveedor del servicio"
                  },
                  telefono: {
                     bsonType: "string",
                     description: "Número de teléfono del proveedor del servicio"
                  }
                  // Otros campos del proveedor del servicio
               }
            }
         }
      }
   }
})


//Proveedores

db.createCollection("Proveedores", {
   validator: {
      $jsonSchema: {
         bsonType: "object",
         required: ["nombre", "ubicacion", "modeloNegocio", "suscripcion", "paquetesMensuales", "opcionesPago"],
         properties: {
            nombre: {
               bsonType: "string",
               description: "Nombre del proveedor de servicios"
            },
            ubicacion: {
               bsonType: "object",
               required: ["direccion", "ciudad", "pais"],
               properties: {
                  direccion: {
                     bsonType: "string",
                     description: "Dirección del proveedor de servicios"
                  },
                  ciudad: {
                     bsonType: "string",
                     description: "Ciudad del proveedor de servicios"
                  },
                  pais: {
                     bsonType: "string",
                     description: "País del proveedor de servicios"
                  }
               }
            },
            modeloNegocio: {
               bsonType: "string",
               description: "Modelo de negocio del proveedor de servicios"
            },
            suscripcion: {
               bsonType: "string",
               description: "Tipo de suscripción del proveedor de servicios"
            },
            paquetesMensuales: {
               bsonType: "array",
               description: "Paquetes mensuales ofrecidos por el proveedor de servicios",
               items: {
                  bsonType: "string",
                  description: "Paquete mensual ofrecido"
               }
            },
            opcionesPago: {
               bsonType: "array",
               description: "Opciones de pago ofrecidas por el proveedor de servicios",
               items: {
                  bsonType: "string",
                  description: "Opción de pago ofrecida"
               }
            }
            // Otros campos adicionales que desees almacenar del proveedor de servicios
         }
      }
   }
})


//Historial preguntas respuestas


db.createCollection("HistorialPreguntasRespuestas", {
   validator: {
      $jsonSchema: {
         bsonType: "object",
         required: ["usuario", "consulta", "respuesta", "timestamp"],
         properties: {
            usuario: {
               bsonType: "string",
               description: "ID del usuario que realizó la consulta"
            },
            consulta: {
               bsonType: "string",
               description: "Consulta realizada por el usuario"
            },
            respuesta: {
               bsonType: "string",
               description: "Respuesta proporcionada por el sistema de AI de AIBulb"
            },
            aclaraciones: {
               bsonType: "array",
               items: {
                  bsonType: "string",
                  description: "Aclaraciones solicitadas por el usuario o proporcionadas por el sistema de AI"
               }
            },
            timestamp: {
               bsonType: "date",
               description: "Timestamp de la interacción de preguntas y respuestas"
            }
            // Otros campos adicionales que desees almacenar en el historial
         }
      }
   }
})

//Solicitudes Servicio


db.createCollection("SolicitudesServicio", {
   validator: {
      $jsonSchema: {
         bsonType: "object",
         required: ["usuario", "tipoServicio", "parametrosBusqueda", "respuestaAI", "timestamp"],
         properties: {
            usuario: {
               bsonType: "string",
               description: "ID del usuario que realizó la solicitud de servicio"
            },
            tipoServicio: {
               bsonType: "string",
               description: "Tipo de servicio solicitado por el usuario"
            },
            parametrosBusqueda: {
               bsonType: "object",
               additionalProperties: true,
               description: "Parámetros de búsqueda proporcionados por el usuario para la solicitud de servicio"
            },
            respuestaAI: {
               bsonType: "string",
               description: "Respuesta del sistema de AI de AIBulb a la solicitud de servicio"
            },
            timestamp: {
               bsonType: "date",
               description: "Timestamp de la solicitud de servicio"
            }
            // Otros campos adicionales que desees almacenar en la solicitud de servicio
         }
      }
   }
})

//Calificaciones comentarios


db.createCollection("CalificacionesComentarios", {
   validator: {
      $jsonSchema: {
         bsonType: "object",
         required: ["usuario", "proveedorServicio", "calificacion", "comentario", "fecha"],
         properties: {
            usuario: {
               bsonType: "string",
               description: "ID del usuario que proporcionó la calificación y comentario"
            },
            proveedorServicio: {
               bsonType: "objectId",
               description: "ID del proveedor de servicios al que se refiere la calificación y comentario"
            },
            calificacion: {
               bsonType: "number",
               minimum: 1,
               maximum: 5,
               description: "Calificación numérica del servicio proporcionado por el proveedor"
            },
            comentario: {
               bsonType: "string",
               description: "Comentario escrito por el usuario sobre el servicio proporcionado"
            },
            fecha: {
               bsonType: "date",
               description: "Fecha en la que se proporcionó la calificación y comentario"
            }
            // Otros campos adicionales que desees almacenar en la calificación y comentario
         }
      }
   }
})

//Geolocalizacion

db.createCollection("Geolocalizacion", {
   validator: {
      $jsonSchema: {
         bsonType: "object",
         required: ["tipo", "latitud", "longitud"],
         properties: {
            tipo: {
               bsonType: "string",
               description: "Tipo de entidad geolocalizada, por ejemplo, 'usuario' o 'proveedorServicio'"
            },
            latitud: {
               bsonType: "number",
               minimum: -90,
               maximum: 90,
               description: "Latitud de la ubicación geográfica"
            },
            longitud: {
               bsonType: "number",
               minimum: -180,
               maximum: 180,
               description: "Longitud de la ubicación geográfica"
            },
            direccion: {
               bsonType: "string",
               description: "Dirección de la ubicación geográfica, si está disponible"
            }
            // Otros campos adicionales que desees almacenar relacionados con la geolocalización
         }
      }
   }
})

//HistorialCompras

db.createCollection("HistorialCompras", {
   validator: {
      $jsonSchema: {
         bsonType: "object",
         required: ["usuarioId", "producto", "precio", "fechaCompra"],
         properties: {
            usuarioId: {
               bsonType: "objectId",
               description: "ID del usuario que realizó la compra"
            },
            producto: {
               bsonType: "string",
               description: "Nombre o descripción del producto o servicio adquirido"
            },
            precio: {
               bsonType: "decimal",
               minimum: 0,
               description: "Precio de compra del producto o servicio"
            },
            fechaCompra: {
               bsonType: "date",
               description: "Fecha y hora de la compra"
            },
            // Otros campos adicionales que desees almacenar relacionados con el historial de compras
         }
      }
   }
})

//configuracion

db.createCollection("configuracion", {
   validator: {
      $jsonSchema: {
      bsonType: "object",
      required: [
         "parametro",
         "valor",
         "descripcion"
      ],
      properties: {
         parametro: {
            bsonType: "string",
            description: "Nombre del parámetro de configuración"
         },
         valor: {
            bsonType: ["string", "int", "bool", "double"],
            description: "Valor del parámetro de configuración"
         },
         descripcion: {
            bsonType: "string",
            description: "Descripción del parámetro de configuración"
         }
      }
      }
   }
});















