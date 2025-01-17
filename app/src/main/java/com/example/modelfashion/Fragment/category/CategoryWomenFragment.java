package com.example.modelfashion.Fragment.category;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.modelfashion.Adapter.category.CategoryAdapter;
import com.example.modelfashion.Adapter.category.ClothesAdapter;
import com.example.modelfashion.Model.response.category.Category;
import com.example.modelfashion.Model.response.product.ProductPreview;
import com.example.modelfashion.R;
import com.example.modelfashion.customview.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;


public class CategoryWomenFragment extends Fragment{
    private CategoryAdapter categoryAdapter;
    private ClothesAdapter clothesAdapter;
    private RecyclerView rcvCategory, rcvClothes;

    private int currentCategory = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category_women, container, false);

        initView(view);
        initData();
        initListener();

        return view;
    }

    private void initData() {
    }

    private void initListener() {
        categoryAdapter.setClickListener((view, position) -> {
            currentCategory = position;
            categoryAdapter.highLightSelectedItem(position);
            // TODO category

        });

        clothesAdapter.setClickListener((view, position) -> {
            // TODO clothes
        });
    }

    private void initView(View view) {
        categoryAdapter = new CategoryAdapter();
        categoryAdapter.setListCategory(listCategory1());
        rcvCategory = view.findViewById(R.id.rcv_category);
        rcvCategory.setAdapter(categoryAdapter);
        categoryAdapter.highLightSelectedItem(currentCategory);

        rcvClothes = view.findViewById(R.id.rcv_clothes);
        clothesAdapter = new ClothesAdapter();
        clothesAdapter.setListProduct(listProduct());
        rcvClothes.setAdapter(clothesAdapter);
        rcvClothes.addItemDecoration(new SpacesItemDecoration(8));

    }

    private List<Category> listCategory1() {
        ArrayList<Category> list = new ArrayList();
        list.add(new Category("1", "Ba lô", 30));
        list.add(new Category("2", "Quần", 30));
        list.add(new Category("3", "Áo", 30));
        list.add(new Category("4", "Giày", 30));
        list.add(new Category("5", "Đồ bộ", 30));
        return list;
    }

    private List<ProductPreview> listProduct() {
        ArrayList<ProductPreview> list = new ArrayList();
        list.add(new ProductPreview("1", "KIDO SHIRT - BLACK", 21321.0, "", "https://zunezx.com/upload/image/cache/data/banner/Tee/47CC5493-74D4-4164-8454-67A648B99FEA-9d1-crop-400-400.jpeg", "S", 10, 6));
        list.add(new ProductPreview("2", "TOSHIRO JACKET", 21321.0, "", "https://zunezx.com/upload/image/cache/data/banner/---bAnnEr-tU-chE/2438672C-DE86-413E-8DFA-8B254077B672-0ac-crop-400-400.jpeg", "S", 20, 1));
        list.add(new ProductPreview("3", "GD - BLACK", 21321.0, "", "", "M", 0, 30));
        list.add(new ProductPreview("4", "GD - WHITE", 21321.0, "", "", "M", 0, 30));
        list.add(new ProductPreview("5", "GD - BLACK", 21321.0, "", "", "M", 0, 30));
        list.add(new ProductPreview("6", "Quần 2", 21321.0, "", "", "M", 0, 30));
        list.add(new ProductPreview("7", "Quần 3", 21321.0, "", "", "M", 0, 30));
        list.add(new ProductPreview("8", "Ba lô 1", 21321.0, "", "", "M", 0, 30));
        return list;
    }
}