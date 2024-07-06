package com.example.shop_taro.Model.dagger

import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.shop_taro.Model.Cart
import com.example.shop_taro.Model.Catalog
import com.example.shop_taro.R
import dagger.Component
import dagger.Module
import dagger.Provides


@Component(modules = [CatalogModule::class])
interface CatalogComponent {
    val catalog: Catalog
}

@Module
class CatalogModule {
    @Provides
    fun provideCatalog(cart: Cart?): Catalog {
        return Catalog(cart!!)
    }

    @Provides
    fun provideCart(): Cart {
        return Cart()
    }
}


//// Usage in your application:
//class YourApplication : Application() {
//    private var catalogComponent: CatalogComponent? = null
//
//    override fun onCreate() {
//        super.onCreate()
//
//        catalogComponent = DaggerCatalogComponent.create()
//    }
//
//    val catalog: Catalog
//        // ...
//        get() = catalogComponent!!.catalog
//}
//
//
//// Usage in other classes:
//class YourActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_your)
//
//        val catalog =
//            (application as YourApplication).catalog
//        // ... use catalog
//    }
//}
