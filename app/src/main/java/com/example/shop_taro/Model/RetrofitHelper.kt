package com.example.shop_taro.Model

import kotlinx.coroutines.runBlocking
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import javax.inject.Inject

data class isRegistered(
    var isRegistered:Int //количество таких пользователей
)
data class id_Order(
    var id_order:Int //количество таких пользователей
)

data class Customer(
    val id: Int?=null,
    val name: String? = null,
    val email:String?=null
)
data class CartOfCustomer(
    var listOfProductsInCart: MutableList<Product?> = mutableListOf(),
    var idCustomer:Int
)
data class catalogFromDB(
    var catalogList: MutableList<Product?> = mutableListOf()
)
data class ordersFromDB(
    var ordersList: MutableList<Order> = mutableListOf()
)

interface QuotesApi {
    @GET("/Customers")
    suspend fun checkLogin(@Body requestBody: Customer) : Response<isRegistered>

    @GET("/Customers")
    suspend fun saveAccount(@Body requestBody: Customer) : Response<Customer>

    @GET("/")//обновить
    suspend fun getCatalog() : Response<MutableList<Product>>//done

    @GET("/Orders")//обновить
    suspend fun getOrders(@Body requestBody: Int) : Response<ordersFromDB>

    @POST("/api/make_order")
    suspend fun make_order(@Body requestBody: Order): Response<id_Order>//done

}

class RetrofitHelper @Inject constructor():IRepository {
    private val baseUrl2="https://4e18-2a00-1370-8180-4cb1-5455-8c27-77b1-8252.ngrok-free.app"
    private val baseUrl = "https://api.restful-api.dev"
    val quotesApi: QuotesApi = Retrofit
        .Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(QuotesApi::class.java)
    override fun make_order(order:Order): Int{
        val res:Int
        runBlocking {
            res=quotesApi.make_order(order).body()!!.id_order
        }
        return res
    }
    override fun checkLogin(name:String, email:String):Int {
        var res:Int
        runBlocking {
            res= quotesApi.checkLogin(Customer(null,name,email)).body()!!.isRegistered
        }
        return res
    }
    override  fun saveAccount(name:String, email:String):Int? {
        var res:Int?
        runBlocking {
            res= quotesApi.saveAccount(Customer(null,name,email)).body()!!.id
        }
        return res
    }
    override fun getCatalog(): MutableList<Product> {
        var listOfProducts:MutableList<Product>
        runBlocking {
            listOfProducts = quotesApi.getCatalog().body()!!
        }
        return listOfProducts
    }
    override  fun getOrders(id:Int): MutableList<Order> {
        var listOfOrders: MutableList<Order>
        runBlocking {
            listOfOrders = quotesApi.getOrders(id).body()!!.ordersList
        }
        return listOfOrders
    }
    override fun getData(): MutableList<String> {
        TODO("Not yet implemented")
    }

    override fun saveData(s1: String, s2: String) {
        TODO("Not yet implemented")
    }

    override fun delDB() {
        TODO("Not yet implemented")
    }


}