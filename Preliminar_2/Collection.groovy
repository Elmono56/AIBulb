db.HistorialConversaciones.insertOne(
   {
      ID: 5,
      historial:[
         {
            consulta: "¿Tienen servicio de delivery para alimentos?",
            respuesta: "Sí, ofrecemos servicio de delivery para alimentos. Puede hacer su pedido a través de nuestra página web o nuestra aplicación móvil."
         },
         {
            consulta: "¿Cuáles son todas las opciones que tienen?",
            respuesta: "Contamos con el servicio de delivery de alimentos del proveedor Food Express S.A, también contamos con servicios similares como delivery de comida gourmet y delivery de comida rápida."
         },
         {
            consulta: "Me interesa el servicio de delivery de alimentos, ¿cuáles tarifas tienen?",
            respuesta: "La tarifa del servicio dependerá de la cantidad del pedido. ¿Desea realizar su pedido ahora?"
         },
         {
            consulta: "Sí, quiero ordenar un hotdog con pepinillos",
            respuesta: "Perfecto, ¿Desea añadir algo más?"
         },
         {
            consulta: "No, con eso está bien",
            respuesta: "Entendido. Su pedido será entregado en aproximadamente 30 minutos. El costo del servicio de delivery para su pedido es de $5. ¡Que disfrute su comida!"
         }
      ],
      matches: ["delivery", "alimentos", "servicio"],
      servicios: [
         {
            nombre: "Delivery de alimentos",
            referencia: "https://www.ejemplo.com/delivery-alimentos",
            proveedor: "Food Express S.A.",
            tipo: {
              descripcion: "pago por uso",
              recurrencia: "única vez",
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
              recurrencia: "diaria",
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
              recurrencia: "mensual",
              precio: 15
            },
            proveedor_ID: "GF001"
         }
      ],
      ID_Cliente: "CL001"
   }
)



db.registroPedidos.insertOne(
   {
      Numero_Seguimiento: "SEG001",
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
         pais: "México"
      }
   }
)




 
