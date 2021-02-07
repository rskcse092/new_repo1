//import org.apache.spark.sql.SparkSession
//import org.apache.spark.sql.functions.explode
//import org.apache.spark.sql.functions.sum
//import org.apache.spark.sql.functions.count
//import org.apache.spark.sql.functions.when
//import org.apache.spark.sql.functions.col
//import org.apache.spark.sql.functions.lit
//import org.apache.spark.sql.functions
//object CustProdPur {
//  def main(args: Array[String]): Unit = {
//    val spark = SparkSession.builder().master("local").appName("demo").getOrCreate()
//    spark.sparkContext.setLogLevel("ERROR")
//    val custsDF = spark.read.format("csv").option("InferSchema","true").option("header","true").
//      load("C:\\Users\\rskcse092\\Downloads\\starter\\customers.csv")
//    custsDF.printSchema()
//    custsDF.show()
//    val prodssDF = spark.read.format("csv").option("InferSchema","true").option("header","true").
//      load("C:\\Users\\rskcse092\\Downloads\\starter\\products.csv")
//    prodssDF.printSchema()
//    prodssDF.show()
//    val transsDF = spark.read.format("json").option("InferSchema","true").option("header","true").
//      load("C:\\Users\\rskcse092\\Downloads\\starter\\transactions\\*\\*.json")
//    transsDF.printSchema()
//    transsDF.show(numRows = 20,truncate = false)
//    val transsRenDF = transsDF.withColumnRenamed("customer_id", "tcustomer_id")
//    transsRenDF.show
//    val cTJoinDF = custsDF.join(transsRenDF, custsDF("customer_id") === transsRenDF("tcustomer_id"), "inner").drop("t_customer_id", "date_of_purchase")
//    cTJoinDF.printSchema()
//    cTJoinDF.show()
//    val cTJoinDFEx =  cTJoinDF.select(cTJoinDF("customer_id"), cTJoinDF("loyalty_score"),  explode(cTJoinDF("basket")))
//    cTJoinDFEx.printSchema()
//    cTJoinDFEx.show()
//    val cTJoinDFExR = cTJoinDFEx.selectExpr("customer_id","loyalty_score","col.price","col.product_id as cTJoinDFEx_product_id ")
//    cTJoinDFExR.printSchema()
//    cTJoinDFExR.show()
//    val cTJoinDFExRJoinP = prodssDF.join(cTJoinDFExR, prodssDF("product_id") === cTJoinDFExR("cTJoinDFEx_product_id"), "inner").drop("product_description", "cTJoinDFEx_product_id")
//    cTJoinDFExRJoinP.printSchema()
//    cTJoinDFExRJoinP.show()
//
//    val purcost =  cTJoinDFExRJoinP.groupBy("customer_id", "loyalty_score", "product_id", "product_category")
//      .agg(count("price").alias("purchase_count"))
//    purcost.show()
//
//
//
//
//  }
//
//}
