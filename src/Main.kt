//objectin singleton kullanımı:object keyword u ile başlar, tek bir örneği  (nesnesi(instance) olan sınıfları ifade eder
// oluşturulan  bu nesneye heryerden erişilebilir.

//singleton  anti pattern oluşumu: 1)Bir object tanımladığımızda onun oluşturulan nesnesi statik olarak bulunur
//böylece garbage collector e biz bunu sen silme bunun yaşam döngüsüne ben müdahale edeceğim demiş oluruz.
//Fazlaca farklı objeler oluşturulduğunda ise bu memory alanında çok fazla yer kaplamaya başlar. Sorun budur.
//2) örneğin bir singleton obje tanımladık ve bu profil fotoğrafı ile ilgiliydi. 2 fragment var örneğin 1. fagment da
//bunu kullandık. ve 2. fragment da bu objeye başka bir değer atadık ve başka bir foto kullandık diyelim. biz burada
//1. kullandığımız yerde de manuel olarak bunu değiştirmemiz gerekir. 10 fragment olduğunu düşünürsek bu yönetilmesi
//zor bir hal almaya başlayacaktır bu yüzden singleton kullanımı akıllıca kullanılması gereken bir yapıdır.

object Singleton {                 //objenin singleton kullanımı
    val name = "Singleton"

    fun showName() {
        println(name)
    }

}

//objectin expression kullanımı: objenin bir değişkene eşitlik olarak verilmesi durumu,ya da objenin tamamının
// bir değişken gibi kullanılması durumudur. Peki biz bunu niye kullanırız. Örneğin bir interface ya da class ı
//miras alıyor olsaydık bütün fonksiyonlarını vs miras almamız gerekirdi.ama hepsine ihtiyacımız yok
// ve bir tanesine ihtiyacımız olduğunda Burada  objenin expression kullanımı ile ihtiyacımız olanı alabiliyoruz.



interface Greeting {                    //Interface yerine class da olabilirdi yine expression kullanım olurdu
    fun greet(name: String): String
}

val greetingObject = object : Greeting {        //objenin expression kullanımı
    override fun greet(name: String): String {
        return "Merhaba, $name!"
    }
}


//companion object kullanımı:Singleton kullanımının alt kümesi gibi düşünebiliriz bir sınıfa özel singleton tanımlamış
// oluyoruz ve lifecyle ı o sınıfın lifecycle ına bağlı yani singleton object garbage collector tarafından silinemezken
// companion object yine garbage collector tarafından silinemez fakat içinde bulunduğu o sınıfın yaşam döngüsü
// sona erdiğinde companion object de silinmiş olur. Lifecycle için aşağıdaki örneğe bak:

// object FragmentFactory{}      lifecycle'ı uygulamanın lifecycle ı.

// class HomeFragment{          lifecycle'ı içinde olduğu class'ın lifecycle ı.
// companion object{
// fun blabla()}}


class HomeFragment{
    var valueList:List<String> = listOf()

    companion object{
        fun newInstance(valueList:List<String>):HomeFragment{
            val fragment = HomeFragment()
            fragment.valueList = valueList
            return fragment
        }
    }
}


//Data Objects: Kotlin'de object tanımlamaları, data anahtar kelimesi ile işaretlenebilir. Bu, nesne için toString(),
// equals(), ve hashCode() gibi metodların otomatik olarak oluşturulmasını sağlar.(data classlarda olduğu gibi)

data object MyDataObject {      // data object kullanımı
    val id = 1
    val name = "Data Object"
}


//Bir objenin içindeki değişken visibility modifiers alabilir
object Deneme{
    private var name = "fdsafds"
}


fun main() {
    Singleton.showName() // //objenin singleton kullanımı
    println(Singleton.name)



    val message = greetingObject.greet("Ali") //objenin expression kullanımı
    println(message)

    HomeFragment.newInstance(listOf()) // objenin companion object kullanımı


    println(MyDataObject.id)            //data object kullanımı
}



