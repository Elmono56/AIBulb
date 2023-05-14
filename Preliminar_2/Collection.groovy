db.HistorialConversaciones.insertOne(
   {
         ID: 5,
         consulta: "¿Tienen servicio de delivery para alimentos?",
         respuesta: "Sí, ofrecemos servicio de delivery para alimentos. Puede hacer su pedido a través de nuestra página web o nuestra aplicación móvil.",
         matches: ["delivery", "alimentos", "servicio"],
         servicios: [
         {
            nombre: "Delivery de alimentos",
            referencia: "https://www.ejemplo.com/delivery-alimentos",
            proveedor: "Food Express S.A.",
            tipo: "pago por uso",
            monto: "50",
            proveedor_ID: "FE001"
         }
         ],
         servicios_similares: [
         {
            nombre: "Delivery de comida rápida",
            referencia: "https://www.ejemplo.com/delivery-comida-rapida",
            proveedor: "Fast Food Express S.A.",
            tipo: "pago por uso",
            monto: "40"
            proveedor_ID: "FFE001"
         },
         {
            nombre: "Delivery de comida gourmet",
            referencia: "https://www.ejemplo.com/delivery-comida-gourmet",
            proveedor: "Gourmet Food S.A.",
            tipo: "suscripción",
            monto: "20"
            proveedor_ID: "GF001"
         }
      ],
      ID_Cliente: "CL001"
   }
 )


db.registroPedidos.insertOne(
   {
      ID_Pedido: "PED001",
      ID_Consulta: 5,
      ID_Cliente: "CL001",
      Completado: true,
      Fecha: ISODate("2023-05-14T14:30:00Z"),
      Servicio: {
         nombre: "Delivery de alimentos",
         referencia: "https://www.ejemplo.com/delivery-alimentos",
         proveedor: "Food Express S.A.",
         tipo: "pago por uso",
         proveedor_ID: "FE001"
      },
      Monto: 50.00,
      Método_Pago: "Tarjeta de crédito",
      Dirección_Entrega: {
         calle: "Calle 23",
         número: "456",
         colonia: "Roma",
         ciudad: "Ciudad de México",
         estado: "Distrito Federal",
         código_postal: "06700",
         país: "México"
      }
   }
)


 
