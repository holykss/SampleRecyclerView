package com.nalive.samplerecyclerview;

import android.content.Context;
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
import com.nalive.samplerecyclerview.viewholders.ViewHolderHorizontalBar;
import com.nalive.samplerecyclerview.viewholders.ViewHolderMovie;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding layout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layout = DataBindingUtil.setContentView(this, R.layout.activity_main);

        layout.recyclerView.setHasFixedSize(true);


        {
            // ModelHorizontalBar 리스트에 아이템 객체 넣기
            ArrayList<BaseModel> items = new ArrayList<>();

            items.add(new ModelHorizontalBar("영화 보실래요?"));
            items.add(new ModelMovie(R.drawable.a, "미키마우스"));
            items.add(new ModelMovie(R.drawable.b, "인어공주"));
            items.add(new ModelMovie(R.drawable.c, "디즈니공주"));
            items.add(new ModelMovie(R.drawable.d, "토이스토리"));
            items.add(new ModelMovie(R.drawable.e, "니모를 찾아서"));

            RecyclerView.Adapter adapter = new MyAdpater(items, this);
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
        private Context context;
        private ArrayList<BaseModel> items;

        // Allows to remember the last item shown on screen
        private int lastPosition = -1;

        public MyAdpater(ArrayList<BaseModel> items, Context context) {
            this.items = items;
            this.context = context;
        }

        // 필수로 Generate 되어야 하는 메소드 1 : 새로운 뷰 생성
        @Override
        public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            switch (viewType) {
                case 0:
                    return new ViewHolderHorizontalBar(parent);
                case 1:
                    return new ViewHolderMovie(parent);
                default:
                    return null;
            }
        }

        // 필수로 Generate 되어야 하는 메소드 2 : ListView의 getView 부분을 담당하는 메소드
        @Override
        public void onBindViewHolder(BaseViewHolder holder, int position) {
            holder.onBind(items.get(position));
        }

        // // 필수로 Generate 되어야 하는 메소드 3
        @Override
        public int getItemCount() {
            return items.size();
        }

//        private void setAnimation(View viewToAnimate, int position) {
//            // 새로 보여지는 뷰라면 애니메이션을 해줍니다
//            if (position > lastPosition) {
//                Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
//                viewToAnimate.startAnimation(animation);
//                lastPosition = position;
//            }
//        }


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
