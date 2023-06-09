db.request.insertOne(
   {
      ID: 1,
      historial:[
         {
            consulta: {
               texto: "¿Tienen servicio de delivery para alimentos?",
               hablante: "cliente",
               timestamp: "2023-05-14T10:00:00.000Z"
            },
            respuesta: {
               texto: "Sí, ofrecemos servicio de delivery para alimentos. Puede hacer su pedido a través de nuestra página web o nuestra aplicación móvil.",
               hablante: "AIBULB",
               timestamp: "2023-05-14T10:01:00.000Z"
            }
         },
         {
            consulta: {
               texto: "¿Cuáles son todas las opciones que tienen?",
               hablante: "cliente",
               timestamp: "2023-05-14T10:02:00.000Z"
            },
            respuesta: {
               texto: "Contamos con el servicio de delivery de alimentos del proveedor Food Express S.A, también contamos con servicios similares como delivery de comida gourmet y delivery de comida rápida.",
               hablante: "AIBULB",
               timestamp: "2023-05-14T10:03:00.000Z"
            }
         },
         {
            consulta: {
               texto: "Me interesa el servicio de delivery de alimentos, ¿cuáles tarifas tienen?",
               hablante: "cliente",
               timestamp: "2023-05-14T10:04:00.000Z"
            },
            respuesta: {
               texto: "La tarifa del servicio dependerá de la cantidad del pedido. ¿Desea realizar su pedido ahora?",
               hablante: "AIBULB",
               timestamp: "2023-05-14T10:05:00.000Z"
            }
         },
         {
            consulta: {
               texto: "Sí, quiero ordenar un hotdog con pepinillos",
               hablante: "cliente",
               timestamp: "2023-05-14T10:06:00.000Z"
            },
            respuesta: {
               texto: "Perfecto, ¿Desea añadir algo más?",
               hablante: "AIBULB",
               timestamp: "2023-05-14T10:07:00.000Z"
            }
         },
         {
            consulta: {
               texto: "No, con eso está bien",
               hablante: "cliente",
               timestamp: "2023-05-14T10:08:00.000Z"
            },
            respuesta: {
               texto: "Entendido. Su pedido será entregado en aproximadamente 30 minutos. El costo del servicio de delivery para su pedido es de $5. ¡Que disfrute su comida!",
               hablante: "AIBULB",
               timestamp: "2023-05-14T10:09:00.000Z"
            }
         }
]
,
      matches: ["delivery", "alimentos", "servicio"],
      servicios: [
         {
            nombre: "Delivery de alimentos",
            referencia: "https://www.ejemplo.com/delivery-alimentos",
            proveedor: "Food Express S.A.",
            tipo: {
              descripcion: "pago por uso",
              precio: 5
            },
            proveedor_ID: "FE001"
         }
      ],
      servicios_similares: [
         {
            nombre: "Delivery de comida rápida",
            referencia: "https://www.ejemplo.com/delivery-comida-rapida",
            proveedor: "Fast Food Express S.A.",
            tipo: {
              descripcion: "pago por uso",
              precio: 3
            },
            proveedor_ID: "FFE001"
         },
         {
            nombre: "Delivery de comida gourmet",
            referencia: "https://www.ejemplo.com/delivery-comida-gourmet",
            proveedor: "Gourmet Food S.A.",
            tipo: {
              descripcion: "suscripción",
              precio: 15
            },
            proveedor_ID: "GF001"
         }
      ],
      ID_Cliente: "CL001"
   }
)

//////////////////////////////////////////////////////////////////////////////////////////////////////////////

db.request.insertOne(
   {
      ID: 2,
      historial:[
         {
            consulta: {
               texto:  "¿Qué tipo de vehículos alquilan?",
               hablante: "cliente",
               timestamp: "2023-05-14T10:08:00.000Z"
            },
            respuesta: {
               texto:  "Alquilamos una amplia variedad de vehículos, incluyendo autos, camionetas, SUVs y motocicletas.",
               hablante: "AIBULB",
               timestamp: "2023-05-14T10:09:00.000Z"
            }
         },
         {
            consulta: {
               texto:  "¿Cuáles son los requisitos para alquilar un vehículo?",
               hablante: "cliente",
               timestamp: "2023-05-14T10:08:00.000Z"
            },
            respuesta: {
               texto:  "Debe tener al menos 21 años de edad, una licencia de conducir válida y una tarjeta de crédito con fondos suficientes para cubrir el depósito de garantía y el costo del alquiler.",
               hablante: "AIBULB",
               timestamp: "2023-05-14T10:09:00.000Z"
            }
         },
         {
            consulta: {
               texto:  "¿Cuáles son sus tarifas?",
               hablante: "cliente",
               timestamp: "2023-05-14T10:08:00.000Z"
            },
            respuesta: {
               texto:   "Las tarifas dependen del tipo de vehículo que desea alquilar, la duración del alquiler y la ubicación. Puede encontrar nuestras tarifas actuales en nuestra página web.",
               hablante: "AIBULB",
               timestamp: "2023-05-14T10:09:00.000Z"
            }
                   
         },
         { 
            consulta: {
               texto:  "Necesito alquilar un auto por una semana en la ciudad de Nueva York",
               hablante: "cliente",
               timestamp: "2023-05-14T10:08:00.000Z"
            },
            respuesta: {
               texto:    "Perfecto, tenemos varias opciones disponibles para alquilar un auto en la ciudad de Nueva York. ¿Puede proporcionarme más detalles sobre su preferencia de vehículo y fechas de alquiler?",
               hablante: "AIBULB",
               timestamp: "2023-05-14T10:09:00.000Z"
            }
         },
         {
            consulta: {
               texto:  "Me gustaría alquilar un sedán mediano del 1 de junio al 8 de junio",
               hablante: "cliente",
               timestamp: "2023-05-14T10:08:00.000Z"
            },
            respuesta: {
               texto:     "Entendido. Hay un sedán mediano disponible en nuestra ubicación de Manhattan que satisface sus necesidades. El costo total del alquiler es de $350, que incluye el depósito de garantía. ¿Le gustaría proceder con la reserva?",
               hablante: "AIBULB",
               timestamp: "2023-05-14T10:09:00.000Z"
            }
         },
         {
             consulta: {
               texto:   "Sí, procedamos con la reserva",
               hablante: "cliente",
               timestamp: "2023-05-14T10:08:00.000Z"
            },
            respuesta: {
               texto:     "Excelente, su reserva ha sido confirmada. Por favor, asegúrese de leer y firmar nuestro contrato de alquiler antes de recoger el vehículo. ¡Gracias por elegirnos!",
               hablante: "AIBULB",
               timestamp: "2023-05-14T10:09:00.000Z"
            }
         }
      ],
      matches: ["alquiler", "vehículo", "tarifas"],
      servicios: [
         {
            nombre: "Alquiler de vehículos",
            referencia: "https://www.ejemplo.com/alquiler-vehiculos",
            proveedor: "Rent-a-car S.A.",
            tipo: {
              descripcion: "pago por uso",
              precio: 50
            },
            proveedor_ID: "RC001"
         }
      ],
      servicios_similares: [
         {
            nombre: "Alquiler de motocicletas",
            referencia: "https://www.ejemplo.com/alquiler-motocicletas",
            proveedor: "MotoRent S.A.",
            tipo: {
              descripcion: "pago por uso",
              precio: 30
            },
            proveedor_ID: "MR001"
         },
         {
            nombre: "Alquiler de camionetas",
            referencia: "https://www.ejemplo.com/alquiler-camionetas",
            proveedor: "TruckRental S.A.",
            tipo: {
              descripcion: "pago por uso",
              precio: 75
            },
            proveedor_ID: "TR001"
         }
      ],
      ID_Cliente: "CL002"
   }
)

//////////////////////////////////////////////////////////////////////////////////////////////////////////////

db.request.insertOne(
   {
      ID: 3,
      historial:[
         {
             consulta: {
               texto:   "Buenos días, ¿qué servicios ofrecen?",
               hablante: "cliente",
               timestamp: "2023-05-14T10:08:00.000Z"
            },
            respuesta: {
               texto:     "¡Buenos días! Ofrecemos una amplia variedad de servicios. ¿En qué podemos ayudarle?",
               hablante: "AIBULB",
               timestamp: "2023-05-14T10:09:00.000Z"
            }
         },
         {
             consulta: {
               texto:   "Estoy buscando un servicio de limpieza para mi hogar",
               hablante: "cliente",
               timestamp: "2023-05-14T10:08:00.000Z"
            },
            respuesta: {
               texto:     "¡Por supuesto! Contamos con un servicio de limpieza residencial que puede ser programado semanal o quincenalmente.",
               hablante: "AIBULB",
               timestamp: "2023-05-14T10:09:00.000Z"
            }
         },
         {
             consulta: {
               texto:   "¿Cuál es el precio del servicio de limpieza?",
               hablante: "cliente",
               timestamp: "2023-05-14T10:08:00.000Z"
            },
            respuesta: {
               texto:     "El precio del servicio de limpieza residencial depende del tamaño de su hogar y de la frecuencia del servicio. ¿Podría proporcionarme más detalles?",
               hablante: "AIBULB",
               timestamp: "2023-05-14T10:09:00.000Z"
            }
         },
         {
             consulta: {
               texto:   "Mi hogar tiene 3 habitaciones y 2 baños. Me gustaría programar el servicio semanalmente",
               hablante: "cliente",
               timestamp: "2023-05-14T10:08:00.000Z"
            },
            respuesta: {
               texto:     "Perfecto, el precio del servicio semanal para un hogar de 3 habitaciones y 2 baños es de $100. ¿Desea programar el servicio ahora?",
               hablante: "AIBULB",
               timestamp: "2023-05-14T10:09:00.000Z"
            }
         },
         {

            consulta: {
               texto:   "Sí, me gustaría programarlo para el próximo lunes a las 9:00am",
               hablante: "cliente",
               timestamp: "2023-05-14T10:08:00.000Z"
            },
            respuesta: {
               texto:     "Entendido, su servicio de limpieza ha sido programado para el próximo lunes a las 9:00am. ¿Necesita ayuda con algo más?",
               hablante: "AIBULB",
               timestamp: "2023-05-14T10:09:00.000Z"
            }
         }
      ],
      matches: ["servicios", "limpieza", "residencial"],
      servicios: [
         {
            nombre: "Servicio de limpieza residencial",
            referencia: "https://www.ejemplo.com/servicio-limpieza-residencial",
            proveedor: "Clean Homes S.A.",
            tipo: {
              descripcion: "pago por uso",
              precio: 100
            },
            proveedor_ID: "CH001"
         }
      ],
      servicios_similares: [
         {
            nombre: "Servicio de limpieza de oficinas",
            referencia: "https://www.ejemplo.com/servicio-limpieza-oficinas",
            proveedor: "Clean Offices S.A.",
            tipo: {
              descripcion: "pago por uso",
              precio: 80
            },
            proveedor_ID: "CO001"
         },
         {
            nombre: "Servicio de limpieza de ventanas",
            referencia: "https://www.ejemplo.com/servicio-limpieza-ventanas",
            proveedor: "Clean Windows S.A.",
            tipo: {
              descripcion: "pago por uso",
              precio: 50
            },
            proveedor_ID: "CW001"
         }
      ],
      ID_Cliente: "CL003"
   }
)

//////////////////////////////////////////////////////////////////////////////////////////////////////////////

db.request.insertOne(
   {
      ID: 4,
      historial:[
         {
            consulta: {
               texto:    "Hola, estoy interesado en contratar un servicio de jardinería",
               hablante: "cliente",
               timestamp: "2023-05-14T10:08:00.000Z"
            },
            respuesta: {
               texto:     "¡Hola! ¡Claro que sí! ¿Podría proporcionarme más detalles sobre el servicio que está buscando?",
               hablante: "AIBULB",
               timestamp: "2023-05-14T10:09:00.000Z"
            }
         },
         {
            consulta: {
               texto:     "Quisiera un servicio semanal para el cuidado de mi jardín",
               hablante: "cliente",
               timestamp: "2023-05-14T10:08:00.000Z"
            },
            respuesta: {
               texto:     "¡Por supuesto! Contamos con un servicio semanal de cuidado de jardines que incluye corte de césped, poda y fertilización.",
               hablante: "AIBULB",
               timestamp: "2023-05-14T10:09:00.000Z"
            }
         },
         {
            consulta: {
               texto:     "¿Cuál es el precio del servicio?",
               hablante: "cliente",
               timestamp: "2023-05-14T10:08:00.000Z"
            },
            respuesta: {
               texto:     "El precio del servicio de cuidado de jardines depende del tamaño de su jardín y de la frecuencia del servicio. ¿Podría proporcionarme más detalles?",
               hablante: "AIBULB",
               timestamp: "2023-05-14T10:09:00.000Z"
            }
         },
         {
            consulta: {
               texto:     "Mi jardín es de tamaño mediano, ¿cuál sería el precio para el servicio semanal?",
               hablante: "cliente",
               timestamp: "2023-05-14T10:08:00.000Z"
            },
            respuesta: {
               texto:     "Para un jardín de tamaño mediano, el precio para el servicio semanal sería de $80. ¿Le gustaría programar el servicio?",
               hablante: "AIBULB",
               timestamp: "2023-05-14T10:09:00.000Z"
            }
         },
         {
            consulta: {
               texto:    "Sí, me gustaría programarlo para los sábados a las 10:00am",
               hablante: "cliente",
               timestamp: "2023-05-14T10:08:00.000Z"
            },
            respuesta: {
               texto:      "Entendido, su servicio de cuidado de jardines ha sido programado para los sábados a las 10:00am. ¿Necesita ayuda con algo más?",
               hablante: "AIBULB",
               timestamp: "2023-05-14T10:09:00.000Z"
            }
         }
      ],
      matches: ["jardinería", "servicio", "semanal"],
      servicios: [
         {
            nombre: "Servicio de cuidado de jardines",
            referencia: "https://www.ejemplo.com/servicio-cuidado-jardines",
            proveedor: "Green Gardens S.A.",
            tipo: {
              descripcion: "pago por uso",
              precio: 80
            },
            proveedor_ID: "GG001"
         }
      ],
      servicios_similares: [
         {
            nombre: "Servicio de diseño de jardines",
            referencia: "https://www.ejemplo.com/servicio-diseno-jardines",
            proveedor: "Artistic Gardens S.A.",
            tipo: {
              descripcion: "pago por uso",
              precio: 150
            },
            proveedor_ID: "AG001"
         },
         {
            nombre: "Servicio de poda de árboles",
            referencia: "https://www.ejemplo.com/servicio-poda-arboles",
            proveedor: "Tree Care S.A.",
            tipo: {
              descripcion: "pago por uso",
              precio: 120
            },
            proveedor_ID: "TC001"
         }
      ],
      ID_Cliente: "CL004"
   }
)

//////////////////////////////////////////////////////////////////////////////////////////////////////////////


db.request.insertOne(
   {
      ID: 5,
      historial:[
         {
            consulta: {
               texto:    "Hola, ¿tienen servicio de reparación de electrodomésticos?",
               hablante: "cliente",
               timestamp: "2023-05-14T10:08:00.000Z"
            },
            respuesta: {
               texto:       "Buenas tardes, sí, ofrecemos servicio de reparación de electrodomésticos. ¿En qué podemos ayudarle?",
               hablante: "AIBULB",
               timestamp: "2023-05-14T10:09:00.000Z"
            }
         },
         {
            consulta: {
               texto:   "Tengo una lavadora que no funciona, ¿pueden repararla?",
               hablante: "cliente",
               timestamp: "2023-05-14T10:08:00.000Z"
            },
            respuesta: {
               texto:       "Sí, podemos reparar su lavadora. ¿Podría proporcionarme la marca y el modelo del electrodoméstico?",
               hablante: "AIBULB",
               timestamp: "2023-05-14T10:09:00.000Z"
            }
         },
         {
            consulta: {
               texto:   "Es una lavadora LG modelo XYZ123",
               hablante: "cliente",
               timestamp: "2023-05-14T10:08:00.000Z"
            },
            respuesta: {
               texto:       "Entendido, la reparación de su lavadora tendría un costo de $150. ¿Le gustaría programar una cita para la reparación?",
               hablante: "AIBULB",
               timestamp: "2023-05-14T10:09:00.000Z"
            }
         },
         {
            consulta: {
               texto:   "Sí, ¿cuál es la próxima fecha disponible?",
               hablante: "cliente",
               timestamp: "2023-05-14T10:08:00.000Z"
            },
            respuesta: {
               texto:    "La próxima fecha disponible es el próximo jueves a las 10:00am. ¿Le funciona esa fecha y hora?",
               hablante: "AIBULB",
               timestamp: "2023-05-14T10:09:00.000Z"
            }
         },
         {
            consulta: {
               texto:   "Sí, me funciona. ¿Qué debo hacer para programar la cita?",
               hablante: "cliente",
               timestamp: "2023-05-14T10:08:00.000Z"
            },
            respuesta: {
               texto:"Para programar la cita, necesitaré su nombre completo, dirección y número de teléfono. Además, le pediré que proporcione una tarjeta de crédito para reservar la cita. ¿Está bien?",
               hablante: "AIBULB",
               timestamp: "2023-05-14T10:09:00.000Z"
            }
         },
         {
            consulta: {
               texto:   "Sí, está bien. Mi nombre es Juan Pérez, mi dirección es Calle 123, número 456, y mi teléfono es 555-1234",
               hablante: "cliente",
               timestamp: "2023-05-14T10:08:00.000Z"
            },
            respuesta: {
               texto:"Gracias, Juan. He programado su cita para el próximo jueves a las 10:00am. Recibirá un correo electrónico con los detalles de su cita. ¿Necesita ayuda con algo más?",
               hablante: "AIBULB",
               timestamp: "2023-05-14T10:09:00.000Z"
            }
         }
      ],
      matches: ["reparación", "electrodomésticos", "lavadora"],
      servicios: [
         {
            nombre: "Reparación de electrodomésticos",
            referencia: "https://www.ejemplo.com/reparacion-electrodomesticos",
            proveedor: "ReparaTodo S.A.",
            tipo: {
              descripcion: "pago por servicio",
              precio: 150
            },
            proveedor_ID: "ZT001"
         }
      ],
      servicios_similares: [
         {
            nombre: "Mantenimiento de aire acondicionado",
            referencia: "https://www.ejemplo.com/mantenimiento-aire-acondicionado",
            proveedor: "CoolFix S.A.",
            tipo: {
              descripcion: "pago por servicio",
              precio: 100
            },
            proveedor_ID: "ZF001"
         },
         {
            nombre: "Reparación de refrigeradores",
            referencia: "https://www.ejemplo.com/reparacion-refrigeradores",
            proveedor: "Frigos S.A.",
            tipo: {
              descripcion: "pago por servicio",
              precio: 200
            },
            proveedor_ID: "ZR001"
         }
      ],
      ID_Cliente: "CL005"
   }
)

//////////////////////////////////////////////////////////////////////////////////////////////////////////////


db.logRequest.insertOne(
   {
      Numero_Seguimiento: "1",
      ID_Pedido: "PED001",
      ID_Cliente: "CL001",
      Completado: true,
      Fecha_Pedido: ISODate("2023-05-14T14:30:00Z"),
      Fecha_Entrega: ISODate("2023-05-15T12:00:00Z"),
      Servicio: {
         nombre: "Delivery de alimentos",
         referencia: "https://www.ejemplo.com/delivery-alimentos",
         proveedor: "Food Express S.A.",
         proveedor_contacto: {
            correo_electronico: "info@foodexpress.com",
            telefono: "+52 555 123 4567"
         },
         tipo: "pago por uso",
         proveedor_ID: "FE001",
         veces_utilizado: 3,
         ultima_fecha_uso: ISODate("2023-05-10T15:45:00Z")
      },
      Monto: {
         subtotal: 50.00,
         impuestos: 8.00,
         envio: 10.00,
         descuentos: 5.00,
         total: 63.00
      },
      Metodo_Pago: {
         tipo: "Tarjeta de crédito",
         informacion: {
            numero_tarjeta: "**** **** **** 1234",
            nombre_tarjeta: "John Doe",
            fecha_expiracion: "12/24",
            codigo_seguridad: "***"
         }
      },
      Direccion_Entrega: {
         nombre_destinatario: "John Doe",
         calle: "Calle 23",
         numero: "456",
         colonia: "Roma",
         ciudad: "Ciudad de México",
         estado: "Distrito Federal",
         codigo_postal: "06700",
         pais: "Mexico"
      }
   }
)

//////////////////////////////////////////////////////////////////////////////////////////////////////////////

db.logRequest.insertOne(
   {
      Numero_Seguimiento: "2",
      ID_Pedido: "PED002",
      ID_Cliente: "CL002",
      Completado: false,
      Fecha_Pedido: ISODate("2023-05-14T16:30:00Z"),
      Fecha_Entrega: null,
      Servicio: {
         nombre: "Reparación de electrodomésticos",
         referencia: "https://www.ejemplo.com/reparacion-electrodomesticos",
         proveedor: "ReparaTodo S.A.",
         proveedor_contacto: {
            correo_electronico: "info@reparatodo.com",
            telefono: "+52 555 123 7890"
         },
         tipo: {
            descripcion: "pago por servicio",
            precio: 150
         },
         proveedor_ID: "ZT001",
         veces_utilizado: 2,
         ultima_fecha_uso: ISODate("2022-12-15T10:30:00Z")
      },
      Monto: {
         subtotal: 150.00,
         impuestos: 24.00,
         envio: 0,
         descuentos: 0,
         total: 174.00
      },
      Metodo_Pago: {
         tipo: "Tarjeta de crédito",
         informacion: {
            numero_tarjeta: "**** **** **** 4321",
            nombre_tarjeta: "Juan Pérez",
            fecha_expiracion: "06/26",
            codigo_seguridad: "***"
         }
      },
      Direccion_Entrega: {
         nombre_destinatario: "Juan Pérez",
         calle: "Calle 123",
         numero: "456",
         colonia: null,
         ciudad: null,
         estado: null,
         codigo_postal: null,
         pais: "Estados Unidos"
      }
   }
)

//////////////////////////////////////////////////////////////////////////////////////////////////////////////

db.logRequest.insertOne(
   {
      Numero_Seguimiento: "3",
      ID_Pedido: "PED003",
      ID_Cliente: "CL003",
      Completado: true,
      Fecha_Pedido: ISODate("2023-05-14T16:30:00Z"),
      Fecha_Entrega: ISODate("2023-05-16T10:00:00Z"),
      Servicio: {
         nombre: "Servicio de limpieza residencial",
         referencia: "https://www.ejemplo.com/servicio-limpieza-residencial",
         proveedor: "Clean Homes S.A.",
         proveedor_contacto: {
            correo_electronico: "info@cleanhomes.com",
            telefono: "+52 555 987 6543"
         },
         tipo: "pago por uso",
         proveedor_ID: "CH001",
         veces_utilizado: 5,
         ultima_fecha_uso: ISODate("2023-05-09T11:15:00Z")
      },
      Monto: {
         subtotal: 100.00,
         impuestos: 16.00,
         envio: 0.00,
         descuentos: 10.00,
         total: 106.00
      },
      Metodo_Pago: {
         tipo: "Tarjeta de crédito",
         informacion: {
            numero_tarjeta: "**** **** **** 5678",
            nombre_tarjeta: "Jane Smith",
            fecha_expiracion: "05/25",
            codigo_seguridad: "***"
         }
      },
      Direccion_Entrega: {
         nombre_destinatario: "Jane Smith",
         calle: "Calle 7",
         numero: "123",
         colonia: "Polanco",
         ciudad: "Ciudad de México",
         estado: "Distrito Federal",
         codigo_postal: "11560",
         pais: "Mexico"
      }
   }
)


//////////////////////////////////////////////////////////////////////////////////////////////////////////////

db.logRequest.insertOne(
   {
      Numero_Seguimiento: "4",
      ID_Pedido: "PED004",
      ID_Cliente: "CL004",
      Completado: false,
      Fecha_Pedido: ISODate("2023-05-14T17:45:00Z"),
      Fecha_Entrega: null,
      Servicio: {
         nombre: "Servicio de cuidado de jardines",
         referencia: "https://www.ejemplo.com/servicio-cuidado-jardines",
         proveedor: "Green Gardens S.A.",
         proveedor_contacto: {
            correo_electronico: "info@greengardens.com",
            telefono: "+52 555 123 4567"
         },
         tipo: "pago por uso",
         proveedor_ID: "GG001",
         veces_utilizado: 2,
         ultima_fecha_uso: ISODate("2023-05-09T14:30:00Z")
      },
      Monto: {
         subtotal: 80.00,
         impuestos: 12.80,
         envio: 0.00,
         descuentos: 0.00,
         total: 92.80
      },
      Metodo_Pago: {
         tipo: "Tarjeta de crédito",
         informacion: {
            numero_tarjeta: "**** **** **** 1234",
            nombre_tarjeta: "John Doe",
            fecha_expiracion: "10/25",
            codigo_seguridad: "***"
         }
      },
      Direccion_Entrega: {
         nombre_destinatario: "John Doe",
         calle: "Calle 10",
         numero: "456",
         colonia: "Condesa",
         ciudad: "Ciudad de México",
         estado: "Distrito Federal",
         codigo_postal: "06140",
         pais: "Mexico"
      }
   }
)

//////////////////////////////////////////////////////////////////////////////////////////////////////////////

db.logRequest.insertOne(
   {
      Numero_Seguimiento: "5",
      ID_Pedido: "PED005",
      ID_Cliente: "CL005",
      Completado: false,
      Fecha_Pedido: ISODate("2023-05-14T17:45:00Z"),
      Fecha_Entrega: null,
      Servicio: {
         nombre: "Alquiler de vehículos",
         referencia: "https://www.ejemplo.com/alquiler-vehiculos",
         proveedor: "Rent-a-car S.A.",
         proveedor_contacto: {
            correo_electronico: "info@rentacar.com",
            telefono: "+52 555 123 4567"
         },
         tipo: "pago por uso",
         proveedor_ID: "RC001",
         veces_utilizado: 1,
         ultima_fecha_uso: ISODate("2023-05-14T17:45:00Z")
      },
      Monto: {
         subtotal: 350.00,
         impuestos: 56.00,
         envio: 0.00,
         descuentos: 0.00,
         total: 406.00
      },
      Metodo_Pago: {
         tipo: "Tarjeta de crédito",
         informacion: {
            numero_tarjeta: "**** **** **** 1234",
            nombre_tarjeta: "John Doe",
            fecha_expiracion: "10/25",
            codigo_seguridad: "***"
         }
      },
      Direccion_Entrega: {
         nombre_destinatario: "John Doe",
         calle: "Calle 10",
         numero: "456",
         colonia: "Condesa",
         ciudad: "Ciudad de México",
         estado: "Distrito Federal",
         codigo_postal: "06140",
         pais: "Mexico"
      },
      Vehiculo: {
         tipo: "Sedán mediano",
         modelo: "Toyota Corolla",
         año: 2022,
         placa: "ABC-123",
         kilometraje: 5000,
         tanque_lleno: true,
         caracteristicas: ["Aire acondicionado", "Radio AM/FM", "Sistema de navegación"]
      },
      Duracion_Alquiler: {
         fecha_inicio: ISODate("2023-06-01T09:00:00Z"),
         fecha_fin: ISODate("2023-06-08T17:00:00Z"),
         dias_alquiler: 7
      }
   }
)
