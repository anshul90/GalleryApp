package com.example.ishitasinha.galleryapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class TextResizeActivity extends AppCompatActivity {

    private static final String TAG = TextResizeActivity.class.getSimpleName();
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_resize);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                adapter.setRowSize(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    private static class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        int rowSize = 10;

        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.list_item, parent, false));
        }

        @Override
        public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
            changeTextSize(holder.getItemView(), rowSize);
        }

        @Override
        public int getItemCount() {
            return 10;
        }


        void setRowSize(int rowSize) {
            this.rowSize = rowSize;
            notifyDataSetChanged();
        }

        static class ViewHolder extends RecyclerView.ViewHolder {
            View itemView;

            ViewHolder(final View itemView) {
                super(itemView);
                this.itemView = itemView;
            }

            View getItemView() {
                return itemView;
            }
        }
    }

    static void changeTextSize(View v, int size) {
        if (v instanceof ViewGroup) {
            int childCount = ((ViewGroup) v).getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childView = ((ViewGroup) v).getChildAt(i);
                if (childView instanceof TextView) {
                    ((TextView) childView).setTextSize(size);
                }
                if (childView instanceof Button) {
                    ((Button) childView).setTextSize(size);
                }
                if (childView instanceof ViewGroup) {
                    changeTextSize(childView, size);
                }
            }
        }
    }
}
