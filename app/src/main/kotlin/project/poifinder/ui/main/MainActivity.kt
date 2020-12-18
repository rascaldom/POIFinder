package project.poifinder.ui.main

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.naver.maps.geometry.LatLng
import com.naver.maps.geometry.Tm128
import com.naver.maps.map.*
import com.naver.maps.map.overlay.Marker
import org.koin.androidx.viewmodel.ext.android.viewModel
import project.poifinder.R
import project.poifinder.common.NAVER_MAP_DEFAULT_ZOOM
import project.poifinder.common.base.BaseActivity
import project.poifinder.data.model.Item
import project.poifinder.databinding.ActivityMainBinding

class MainActivity : BaseActivity(), OnMapReadyCallback, SearchListAdapter.ListItemClickListener {

    private val binding: ActivityMainBinding by binding(R.layout.activity_main)
    private val viewModel: MainViewModel by viewModel()

    private lateinit var naverMap: NaverMap

    private val marker: Marker = Marker()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            lifecycleOwner = this@MainActivity
            viewModel = this@MainActivity.viewModel
        }

        initializeView()
    }

    private fun initializeView() {
        initializeSearchBar()
        initializeNaverMap()
        initializeSearchListAdapter()
    }

    private fun initializeSearchBar() {
        with (binding.searchBar) {
            setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    viewModel.getSearchList(query ?: "").observe(this@MainActivity, {
                        retrieveList(it)
                    })
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }
            })
        }
    }

    private fun initializeNaverMap() {
        val fm = supportFragmentManager
        val mapFragment = fm.findFragmentById(R.id.map) as MapFragment?
                ?: MapFragment.newInstance().also {
                    fm.beginTransaction().add(R.id.map, it).commit()
                }

        mapFragment.getMapAsync(this)
    }

    private fun initializeSearchListAdapter() {
        with (binding.list) {
            adapter = SearchListAdapter().apply { setItemClickListener(this@MainActivity) }
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        }
    }

    override fun onMapReady(naverMap: NaverMap) {
        this.naverMap = naverMap
    }

    private fun retrieveList(list: List<Item>) {
        (binding.list.adapter as SearchListAdapter).apply {
            setListItems(list)
            notifyDataSetChanged()
        }
    }

    private fun setPoiMarker(item: Item) {
        val coord = convertCoordinates(item.mapx, item.mapy)
        movePosition(coord)
        showMarker(coord, item.title)
    }

    private fun convertCoordinates(x: Double, y: Double): LatLng = Tm128(x, y).toLatLng()

    private fun movePosition(latLng: LatLng) {
        naverMap.moveCamera(CameraUpdate.scrollAndZoomTo(latLng, NAVER_MAP_DEFAULT_ZOOM).animate(CameraAnimation.Easing))
    }

    private fun showMarker(latLng: LatLng, title: String) {
        marker.map = null
        marker.apply {
            position = latLng
            captionText = title
            map = this@MainActivity.naverMap
        }
    }

    override fun onItemClick(view: View, item: Item) {
        setPoiMarker(item)
    }

}