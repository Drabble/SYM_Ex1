package ch.heig_vd.iict.symexercices.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import ch.heig_vd.iict.symexercices.R;

/**
 * A {@link AbstractFragment} subclass.
 * Use the {@link AbstractFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentExercise1 extends AbstractFragment {

    //TODO Exercice 1
    //le contenu de la variable counterValue doit être restauré après un changement de contexz
    private int counterValue = 0;

    //GUI elements
    private TextView tv1    = null;
    private Button btn1     = null;

    public FragmentExercise1() { /*Required empty public constructor*/ }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_exercise1, container, false);

        //we link GUI elements
        this.tv1 = (TextView) v.findViewById(R.id.ex1_tv);
        this.btn1 = (Button) v.findViewById(R.id.ex1_btn);

        //events
        this.btn1.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                ++counterValue;
                updateCounterText();
            }
        });

        //init view
        updateCounterText();

        return v;
    }

    /*
     *  GUI helpers
     */

    private void updateCounterText() {
        this.tv1.setText(getResources().getQuantityString(R.plurals.sct1_click_counter, this.counterValue, this.counterValue));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counterValue", this.counterValue);
    }

    @Override
    public void onViewStateRestored(Bundle inState) {
        super.onViewStateRestored(inState);
        if(inState!=null) {
            counterValue = inState.getInt("counterValue");
            updateCounterText();
        }

    }

}
