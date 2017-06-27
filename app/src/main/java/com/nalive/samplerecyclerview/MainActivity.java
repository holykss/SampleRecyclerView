package com.nalive.samplerecyclerview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nalive.samplerecyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding layout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layout = DataBindingUtil.setContentView(this, R.layout.activity_main);

        layout.recyclerView.setHasFixedSize(true);


        {
            // Item 리스트에 아이템 객체 넣기
            ArrayList<Item> items = new ArrayList<>();

            items.add(new Item(R.drawable.a, null));
            items.add(new Item(R.drawable.a, "미키마우스"));
            items.add(new Item(R.drawable.b, "인어공주"));
            items.add(new Item(R.drawable.c, "디즈니공주"));
            items.add(new Item(R.drawable.d, "토이스토리"));
            items.add(new Item(R.drawable.e, "니모를 찾아서"));

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

    static class MyAdpater extends RecyclerView.Adapter<ViewHolder> {
        private Context context;
        private ArrayList<Item> items;

        // Allows to remember the last item shown on screen
        private int lastPosition = -1;

        public MyAdpater(ArrayList<Item> items, Context context) {
            this.items = items;
            this.context = context;
        }

        // 필수로 Generate 되어야 하는 메소드 1 : 새로운 뷰 생성
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            // 새로운 뷰를 만든다
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item, parent, false);
            ViewHolder holder = new ViewHolder(v);

            if (viewType == -1) {
                holder.setFullSpan();
            }
            return holder;
        }

        // 필수로 Generate 되어야 하는 메소드 2 : ListView의 getView 부분을 담당하는 메소드
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Item item = items.get(position);

            holder.imageView.setImageResource(item.image);
            if (TextUtils.isEmpty(item.imageTitle)) {
                holder.setFullSpan();
            } else {
                holder.textView.setText(item.imageTitle);
            }

//            setAnimation(holder.imageView, position);
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
            if (TextUtils.isEmpty(items.get(position).imageTitle)) {
                return -1;
            }
            return 0;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView;

        public ViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.image);
            textView = (TextView) view.findViewById(R.id.imagetitle);
        }

        public void setFullSpan() {
            ViewGroup viewGroup = (ViewGroup) itemView.getRootView();
            StaggeredGridLayoutManager.LayoutParams params = (StaggeredGridLayoutManager.LayoutParams) viewGroup.getLayoutParams();
            params.setFullSpan(true);
            params.height = 150;
            //params.width = ViewGroup.LayoutParams.MATCH_PARENT;
            //viewGroup.setLayoutParams(params);
        }
    }


}
