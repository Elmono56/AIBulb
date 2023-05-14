USE [master]
GO
/****** Object:  Database [AIBulb]    Script Date: 14/5/2023 00:30:55 ******/
CREATE DATABASE [AIBulb]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'AIBulb', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\AIBulb.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'AIBulb_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\AIBulb_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [AIBulb] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [AIBulb].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [AIBulb] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [AIBulb] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [AIBulb] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [AIBulb] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [AIBulb] SET ARITHABORT OFF 
GO
ALTER DATABASE [AIBulb] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [AIBulb] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [AIBulb] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [AIBulb] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [AIBulb] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [AIBulb] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [AIBulb] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [AIBulb] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [AIBulb] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [AIBulb] SET  DISABLE_BROKER 
GO
ALTER DATABASE [AIBulb] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [AIBulb] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [AIBulb] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [AIBulb] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [AIBulb] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [AIBulb] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [AIBulb] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [AIBulb] SET RECOVERY FULL 
GO
ALTER DATABASE [AIBulb] SET  MULTI_USER 
GO
ALTER DATABASE [AIBulb] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [AIBulb] SET DB_CHAINING OFF 
GO
ALTER DATABASE [AIBulb] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [AIBulb] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [AIBulb] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [AIBulb] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'AIBulb', N'ON'
GO
ALTER DATABASE [AIBulb] SET QUERY_STORE = OFF
GO
USE [AIBulb]
GO
/****** Object:  Table [dbo].[Bills]    Script Date: 14/5/2023 00:30:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bills](
	[idBill] [int] IDENTITY(1,1) NOT NULL,
	[idPayment] [int] NULL,
	[finalAmount] [float] NOT NULL,
	[billDate] [date] NOT NULL,
	[userWallet] [int] NOT NULL,
	[idUsuario] [int] NOT NULL,
	[walletTransNumber] [int] NOT NULL,
 CONSTRAINT [PK_Bills] PRIMARY KEY CLUSTERED 
(
	[idBill] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ContractTypes]    Script Date: 14/5/2023 00:30:56 ******/
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
/****** Object:  Table [dbo].[Countries]    Script Date: 14/5/2023 00:30:56 ******/
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
/****** Object:  Table [dbo].[Devolutions]    Script Date: 14/5/2023 00:30:56 ******/
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
/****** Object:  Table [dbo].[Fees]    Script Date: 14/5/2023 00:30:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Fees](
	[idFee] [int] IDENTITY(1,1) NOT NULL,
	[idPayment] [int] NOT NULL,
	[amount] [float] NOT NULL,
	[dateC] [date] NOT NULL,
 CONSTRAINT [PK_Fees] PRIMARY KEY CLUSTERED 
(
	[idFee] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Payments]    Script Date: 14/5/2023 00:30:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Payments](
	[idPayment] [int] IDENTITY(1,1) NOT NULL,
	[idService] [int] NOT NULL,
	[amountProvider] [float] NOT NULL,
	[paymentDate] [date] NOT NULL,
	[idProduct] [int] NOT NULL,
 CONSTRAINT [PK_Payments] PRIMARY KEY CLUSTERED 
(
	[idPayment] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PaymentXTaxes]    Script Date: 14/5/2023 00:30:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PaymentXTaxes](
	[idPayment] [int] NOT NULL,
	[idTax] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 14/5/2023 00:30:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[idProduct] [int] NOT NULL,
	[productName] [varchar](50) NOT NULL,
	[idContractT] [int] NOT NULL,
 CONSTRAINT [PK_Products] PRIMARY KEY CLUSTERED 
(
	[idProduct] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ProductsXPayments]    Script Date: 14/5/2023 00:30:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProductsXPayments](
	[idPayment] [int] NOT NULL,
	[idProduct] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Taxes]    Script Date: 14/5/2023 00:30:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Taxes](
	[idTax] [int] IDENTITY(1,1) NOT NULL,
	[idCountry] [int] NOT NULL,
	[description] [varchar](50) NOT NULL,
	[percentage] [float] NOT NULL,
	[dateC] [date] NOT NULL,
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
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK_Products_ContractTypes] FOREIGN KEY([idContractT])
REFERENCES [dbo].[ContractTypes] ([idContractT])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_Products_ContractTypes]
GO
ALTER TABLE [dbo].[ProductsXPayments]  WITH CHECK ADD  CONSTRAINT [FK_ProductsXPayments_Payments] FOREIGN KEY([idProduct])
REFERENCES [dbo].[Payments] ([idPayment])
GO
ALTER TABLE [dbo].[ProductsXPayments] CHECK CONSTRAINT [FK_ProductsXPayments_Payments]
GO
ALTER TABLE [dbo].[ProductsXPayments]  WITH CHECK ADD  CONSTRAINT [FK_ProductsXPayments_Products] FOREIGN KEY([idPayment])
REFERENCES [dbo].[Products] ([idProduct])
GO
ALTER TABLE [dbo].[ProductsXPayments] CHECK CONSTRAINT [FK_ProductsXPayments_Products]
GO
ALTER TABLE [dbo].[Taxes]  WITH CHECK ADD  CONSTRAINT [FK_Taxes_Countries] FOREIGN KEY([idCountry])
REFERENCES [dbo].[Countries] ([idCountry])
GO
ALTER TABLE [dbo].[Taxes] CHECK CONSTRAINT [FK_Taxes_Countries]
GO
USE [master]
GO
ALTER DATABASE [AIBulb] SET  READ_WRITE 
GO
