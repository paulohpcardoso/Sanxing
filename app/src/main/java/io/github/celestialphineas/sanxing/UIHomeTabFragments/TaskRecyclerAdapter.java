package io.github.celestialphineas.sanxing.UIHomeTabFragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import io.github.celestialphineas.sanxing.R;
import io.github.celestialphineas.sanxing.SanxingBackend.Task;

/**
 * Created by celestialphineas on 17-10-17.
 * Public class recycler view adapter for the task fragment
 */

public class TaskRecyclerAdapter
        extends RecyclerView.Adapter<TaskRecyclerAdapter.TaskViewHolder> implements View.OnClickListener {

    private List<Task> taskList;
    private OnItemClickListener mOnItemClickListener = null;
    TaskRecyclerAdapter() {
        // Empty constructor
    }

    TaskRecyclerAdapter(List<Task> task_list) {
        taskList = task_list;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
        notifyDataSetChanged();
    }

    class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView cardTitle;
        TextView cardSubheading;
        TaskViewHolder(View itemView) {
            super(itemView);

            cardTitle = itemView.findViewById(R.id.task_card_headline);
            cardSubheading = itemView.findViewById(R.id.task_card_subheading);
            cardSubheading.setText("Good night, my friend!");
        }
        TaskViewHolder(View itemView,String title) {
            super(itemView);

            cardTitle = itemView.findViewById(R.id.task_card_headline);
            cardSubheading = itemView.findViewById(R.id.task_card_subheading);
            cardTitle.setText(title);
            cardSubheading.setText("Good night, my friend!");
        }
        TaskViewHolder(View itemView,List<Task> list) {
            super(itemView);

            taskList = list;
            cardTitle = itemView.findViewById(R.id.task_card_headline);
            cardSubheading = itemView.findViewById(R.id.task_card_subheading);

//           cardTitle.setText("hello world");
//            cardSubheading.setText("Good my friend!");
        }

    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewGroup) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_card, parent, false);
        itemView.setOnClickListener((View.OnClickListener) this);
        return new TaskViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {


        holder.cardTitle.setText(taskList.get(position).getContent());
        holder.cardSubheading.setText("Good for task!");
        //将position保存在itemView的Tag中，以便点击时进行获取
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        // TODO: Implement this, and return how many cards concerned
        return taskList ==null?0: taskList.size();

    }

    //define interface
    public static interface OnItemClickListener {
        void onItemClick(View view , int position);
    }

    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

}
