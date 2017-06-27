package com.nalive.samplerecyclerview;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nalive.samplerecyclerview.databinding.ActivityMainBinding;
import com.nalive.samplerecyclerview.models.BaseModel;
import com.nalive.samplerecyclerview.models.ModelHorizontalBar;
import com.nalive.samplerecyclerview.models.ModelMovie;
import com.nalive.samplerecyclerview.viewholders.BaseViewHolder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding layout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layout = DataBindingUtil.setContentView(this, R.layout.activity_main);

        layout.recyclerView.setHasFixedSize(true);

        {
            ArrayList<BaseModel> items = new ArrayList<>();

            items.add(new ModelHorizontalBar("영화 보실래요?"));
            items.add(new ModelMovie(R.drawable.a, "미키마우스"));
            items.add(new ModelMovie(R.drawable.b, "인어공주"));
            items.add(new ModelMovie(R.drawable.c, "디즈니공주"));
            items.add(new ModelMovie(R.drawable.d, "토이스토리"));
            items.add(new ModelMovie(R.drawable.e, "니모를 찾아서"));

            RecyclerView.Adapter adapter = new MyAdpater(items);
            layout.recyclerView.setAdapter(adapter);
        }

        {
            RecyclerView.LayoutManager layoutManager;
            // StaggeredGrid 레이아웃을 사용한다
            layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
            //layoutManager = new LinearLayoutManager(this);
            //layoutManager = new GridLayoutManager(this,3);

            // 지정된 레이아웃매니저를 RecyclerView에 Set 해주어야한다.
            layout.recyclerView.setLayoutManager(layoutManager);
        }

    }

    static class MyAdpater extends RecyclerView.Adapter<BaseViewHolder> {
        private ArrayList<BaseModel> items;

        public MyAdpater(ArrayList<BaseModel> items) {
            this.items = items;
        }

        @Override
        public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return BaseViewHolder.create(parent, viewType);
        }

        @Override
        public void onBindViewHolder(BaseViewHolder holder, int position) {
            holder.onBind(items.get(position));
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        @Override
        public int getItemViewType(int position) {
            return items.get(position).getViewType();
        }
    }


    @BindingAdapter({"android:src"})
    public static void setImageViewResource(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }
}
