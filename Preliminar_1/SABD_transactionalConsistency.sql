USE [AIBulb]
GO
/****** Object:  Table [dbo].[Bills]    Script Date: 24/4/2023 22:11:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bills](
	[idBill] [int] IDENTITY(1,1) NOT NULL,
	[idPayment] [int] NOT NULL,
	[finalAmount] [float] NOT NULL,
	[billDate] [date] NOT NULL,
 CONSTRAINT [PK_Bills] PRIMARY KEY CLUSTERED 
(
	[idBill] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ContractTypes]    Script Date: 24/4/2023 22:11:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ContractTypes](
	[idContractT] [int] IDENTITY(1,1) NOT NULL,
	[description] [varchar](100) NOT NULL,
	[idService] [int] NOT NULL,
 CONSTRAINT [PK_ContractTypes] PRIMARY KEY CLUSTERED 
(
	[idContractT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Countries]    Script Date: 24/4/2023 22:11:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Countries](
	[idCountry] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Countries] PRIMARY KEY CLUSTERED 
(
	[idCountry] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Devolutions]    Script Date: 24/4/2023 22:11:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Devolutions](
	[idDevolution] [int] IDENTITY(1,1) NOT NULL,
	[idBill] [int] NOT NULL,
	[description] [varchar](100) NOT NULL,
 CONSTRAINT [PK_Devolutions] PRIMARY KEY CLUSTERED 
(
	[idDevolution] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Fees]    Script Date: 24/4/2023 22:11:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Fees](
	[idFee] [int] IDENTITY(1,1) NOT NULL,
	[idPayment] [int] NOT NULL,
	[amount] [float] NOT NULL,
 CONSTRAINT [PK_Fees] PRIMARY KEY CLUSTERED 
(
	[idFee] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Payments]    Script Date: 24/4/2023 22:11:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Payments](
	[idPayment] [int] IDENTITY(1,1) NOT NULL,
	[idService] [int] NOT NULL,
	[idDWallet] [int] NOT NULL,
	[amountProvider] [float] NOT NULL,
	[paymentDate] [date] NOT NULL,
	[idContractT] [int] NOT NULL,
 CONSTRAINT [PK_Payments] PRIMARY KEY CLUSTERED 
(
	[idPayment] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PaymentXTaxes]    Script Date: 24/4/2023 22:11:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PaymentXTaxes](
	[idPayment] [int] NOT NULL,
	[idTax] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Taxes]    Script Date: 24/4/2023 22:11:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Taxes](
	[idTax] [int] IDENTITY(1,1) NOT NULL,
	[idCountry] [int] NOT NULL,
	[description] [varchar](50) NOT NULL,
	[percentage] [float] NOT NULL,
 CONSTRAINT [PK_Taxes] PRIMARY KEY CLUSTERED 
(
	[idTax] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Bills]  WITH CHECK ADD  CONSTRAINT [FK_Bills_Payments] FOREIGN KEY([idPayment])
REFERENCES [dbo].[Payments] ([idPayment])
GO
ALTER TABLE [dbo].[Bills] CHECK CONSTRAINT [FK_Bills_Payments]
GO
ALTER TABLE [dbo].[Devolutions]  WITH CHECK ADD  CONSTRAINT [FK_Devolutions_Bills] FOREIGN KEY([idBill])
REFERENCES [dbo].[Bills] ([idBill])
GO
ALTER TABLE [dbo].[Devolutions] CHECK CONSTRAINT [FK_Devolutions_Bills]
GO
ALTER TABLE [dbo].[Fees]  WITH CHECK ADD  CONSTRAINT [FK_Fees_Payments] FOREIGN KEY([idPayment])
REFERENCES [dbo].[Payments] ([idPayment])
GO
ALTER TABLE [dbo].[Fees] CHECK CONSTRAINT [FK_Fees_Payments]
GO
ALTER TABLE [dbo].[Payments]  WITH CHECK ADD  CONSTRAINT [FK_Payments_ContractTypes] FOREIGN KEY([idContractT])
REFERENCES [dbo].[ContractTypes] ([idContractT])
GO
ALTER TABLE [dbo].[Payments] CHECK CONSTRAINT [FK_Payments_ContractTypes]
GO
ALTER TABLE [dbo].[PaymentXTaxes]  WITH CHECK ADD  CONSTRAINT [FK_PaymentXTaxes_Payments] FOREIGN KEY([idPayment])
REFERENCES [dbo].[Payments] ([idPayment])
GO
ALTER TABLE [dbo].[PaymentXTaxes] CHECK CONSTRAINT [FK_PaymentXTaxes_Payments]
GO
ALTER TABLE [dbo].[PaymentXTaxes]  WITH CHECK ADD  CONSTRAINT [FK_PaymentXTaxes_Taxes] FOREIGN KEY([idTax])
REFERENCES [dbo].[Taxes] ([idTax])
GO
ALTER TABLE [dbo].[PaymentXTaxes] CHECK CONSTRAINT [FK_PaymentXTaxes_Taxes]
GO
ALTER TABLE [dbo].[Taxes]  WITH CHECK ADD  CONSTRAINT [FK_Taxes_Countries] FOREIGN KEY([idCountry])
REFERENCES [dbo].[Countries] ([idCountry])
GO
ALTER TABLE [dbo].[Taxes] CHECK CONSTRAINT [FK_Taxes_Countries]
GO
