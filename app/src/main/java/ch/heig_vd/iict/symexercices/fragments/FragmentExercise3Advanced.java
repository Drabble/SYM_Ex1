package ch.heig_vd.iict.symexercices.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import ch.heig_vd.iict.symexercices.R;

/**
 * A {@link AbstractFragment} subclass.
 * Use the {@link AbstractFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentExercise3Advanced extends AbstractFragment {

    //GUI elements
    private Button btn = null;
    private ListView list = null;
    private TextView empty = null;

    public FragmentExercise3Advanced() { /*Required empty public constructor*/ }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_exercise3, container, false);

        //link to GUI
        this.btn = (Button) v.findViewById(R.id.ex3_lv_btn);
        this.list = (ListView) v.findViewById(R.id.ex3_lv);
        this.empty = (TextView) v.findViewById(R.id.ex3_empty);

        //TODO...

        return v;
    }

}
