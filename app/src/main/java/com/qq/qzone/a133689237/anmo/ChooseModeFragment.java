package com.qq.qzone.a133689237.anmo;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.qq.qzone.a133689237.anmo.Vibrate.Factory;

public class ChooseModeFragment extends DialogFragment implements View.OnClickListener {

    public MainActivity mMainActivity;
    private ListView mListView;
    private String[] strs = new String[4];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_choosemode, container);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

        for (int i=0; i<=3; i++){
            strs[i] = Factory.getName(i+1);
        }

        mListView = (ListView) view.findViewById(R.id.dialog_list_view);
        mListView.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.dialog_listview_item, strs));
        mListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        Button mButton = (Button) view.findViewById(R.id.dialog_daji_button);
        mButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        mMainActivity.changeMode( mListView.getCheckedItemPosition()+1 );
        dismiss();
    }

}


