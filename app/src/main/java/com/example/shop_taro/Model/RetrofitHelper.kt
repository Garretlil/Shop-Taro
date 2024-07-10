package com.example.shop_taro.Model

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

data class isRegistered(
    var isRegistered:Int
)//количество таких пользователей
data class newproduct(
    var id:Int,
    var name:String,
    val description:String,
    val imageResource:Int,
    val price:Int,
    val old_price:Int,
    val amount:Int
)

data class Customer(
    val id: Int,
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
    var idCustomer:Int,
    var ordersList: MutableList<Order> = mutableListOf()
)

interface QuotesApi {
    @GET("/Customers")
    suspend fun checkLogin() : Response<isRegistered>

    @GET("/Customers")
    suspend fun saveAccount() : Response<Customer>

    @GET("/api/products")//обновить
    suspend fun getCatalog() : Response<catalogFromDB>

    @GET("/Orders")//обновить
    suspend fun getOrders(@Body requestBody: Int) : Response<ordersFromDB>

    @POST("/api/make_order")
    suspend fun make_order(@Body requestBody: Order)

}

class RetrofitHelper:IRepository {
    private val baseUrl2="https://4e18-2a00-1370-8180-4cb1-5455-8c27-77b1-8252.ngrok-free.app"
    private val baseUrl = "https://api.restful-api.dev"
    val quotesApi: QuotesApi = Retrofit
        .Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(QuotesApi::class.java)
    override fun make_order(order:Order){
        runBlocking {
            quotesApi.make_order(order)
        }
    }
    override  fun checkLogin(name:String, email:String):Int {
        var res:Int
        runBlocking {
            res= quotesApi.checkLogin().body()!!.isRegistered
        }
        return res
    }
    override  fun saveAccount(name:String, email:String):Int {
        var res:Int
        runBlocking {
            res= quotesApi.saveAccount().body()!!.id
        }
        return res
    }
    override  fun getCatalog(): MutableList<Product?> {
        var listOfProducts: MutableList<Product?>
        runBlocking {
            listOfProducts = quotesApi.getCatalog().body()!!.catalogList
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