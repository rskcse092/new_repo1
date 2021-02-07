
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.Row
import org.apache.spark.sql.types.{StructField, StructType, StringType, IntegerType}

object CreatingDF {
  def main(args: Array[String]): Unit = {
    val spark:SparkSession = SparkSession.builder()
      .master("local").appName("SparkByExamples.com")
      .getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")
    import spark.implicits._
    print("1st approach ")
    val columns = Seq("language","fees")
    val data = Seq(("Java", "20000"), ("Python", "100000"), ("Scala", "3000"))
    val rdd = spark.sparkContext.parallelize(data)
    val dfFromRDD1 = rdd.toDF("language","fees")
    val dfFromRDD2 = rdd.toDF(columns:_*)
    dfFromRDD1.printSchema()
    dfFromRDD1.show()
    dfFromRDD2.printSchema()
    dfFromRDD2.show()
    print("2nd  approach ")
    val data1 = Seq(Row("Sql",3000),Row("mysql",4000),Row("ruby",5000),
      Row("python",5000))
    val rdd1 = spark.sparkContext.parallelize(data1)
    val schema = StructType(Array(
      StructField("language",StringType),
      StructField("fees",IntegerType))
    )
    val DF1 = spark.createDataFrame(rdd1,schema)
    DF1.printSchema()
    DF1.show()
//    print("3rd approach using case class")
//    case class DemoUser(language:String,fees:Int)
//    val data3 = Seq(
//      DemoUser("python",30000),
//      DemoUser("Ruby",40000)
//    )
//    val rdd3 = spark.sparkContext.parallelize(data3)
//    val df3 = rdd3.toDF()
//    df3.printSchema()
//    df3.show()



  }
}
