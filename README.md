# 1  Add the JitPack repository to your build file (build.gradle (Project:..))
```
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
    }
  }
```
# 2  Add the dependency (build.gradle (Module:app))
```
dependencies {
  implementation 'com.github.Nhatran241:BaseRecyclerView_DataBinding:1.0.0'
}
```
# 3 Apply Kapt (build.gradle (Module:app))
```
apply plugin: 'kotlin-kapt'
```
# 4 Enable databinding (build.gradle (Module:app))
```
android {
    buildFeatures {
        dataBinding true
    }
}
```

# 5 Create ViewModel for Activity
```
class MainActivityViewModel{
    var listColor =
        listOf(
            ItemColorViewModel(bgColor = Color.BLACK),
            ItemColorViewModel(bgColor = Color.BLUE),
            ItemColorViewModel(bgColor = Color.CYAN),
            ItemColorViewModel(bgColor = Color.DKGRAY),
            ItemColorViewModel(bgColor = Color.GRAY),
            ItemColorViewModel(bgColor = Color.LTGRAY),
            ItemColorViewModel(bgColor = Color.MAGENTA),
            ItemColorViewModel(bgColor = Color.GREEN),
            ItemColorViewModel(bgColor = Color.YELLOW))

}
```
#6 Layout for Activity databinding to ViewModel
```
<layout>
    <data>
        <variable
            name="viewModel"
            type="com.nhatran241.baserecyclerview_databinding.MainActivityViewModel" />
    </data>
    <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity">
        <androidx.recyclerview.widget.RecyclerView
            setUpColorAdapter="@{viewModel.listColor}"
            android:layout_width="match_parent"
            android:layout_height="match_parent"/>
    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>
```
#7 Activity Class
```
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.viewModel = MainActivityViewModel()
        setContentView(binding.root)
    }
}
```
#8 Create ViewModel for RecyclerView Item
```
class ItemColorViewModel (
    var bgColor : Int = Color.BLACK
)
```
#9  Layout item_color
```
<layout xmlns:android="http://schemas.android.com/apk/res/android">
    <data>
        <variable name="model" type="com.nhatran241.baserecyclerview_databinding.ItemColorViewModel"/>
    </data>
    <LinearLayout
        android:background="@{model.bgColor}"
        android:layout_width="match_parent"
        android:layout_height="100dp"/>
</layout>
```
#10   Adapter for Recyclerview with databinding to Item
```
@BindingAdapter("setUpColorAdapter")
fun RecyclerView.setUpColorAdapter(listColor : List<ItemColorViewModel>?){
    layoutManager =LinearLayoutManager(context)
    adapter = listColor?.let { ColorAdapter(listColor) }
}
class ColorAdapter( data: List<ItemColorViewModel>) :
    BaseAdapter<ItemColorViewModel>( data) {
    lateinit var binding : ItemColorBinding
    override fun getBindingRoot(parent: ViewGroup, viewType: Int): View {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_color,parent ,false)
        return binding.root
    }
    override fun setBindingViewModel(position: ItemColorViewModel) {
        binding.model =position
    }
}
```





