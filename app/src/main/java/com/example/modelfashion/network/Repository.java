package com.example.modelfashion.network;

import android.content.Context;

import com.example.modelfashion.Model.response.category.CategoryResponse;
import com.example.modelfashion.Model.response.product.ProductResponse;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public final class Repository {
    private ApiInterface apiInterface;

    public Repository(Context context){
        this.apiInterface = ApiClient.provideApiInterface(context);
    }

    public Single<CategoryResponse> getCategory(){
        return apiInterface.getCategory("https://test-api-spring-boot.herokuapp.com/api/category/categories")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<ProductResponse> getProductByCategory(String id){
        return apiInterface.getProductByCategory(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
