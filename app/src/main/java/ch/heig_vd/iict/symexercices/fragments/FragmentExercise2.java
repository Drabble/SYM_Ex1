package ch.heig_vd.iict.symexercices.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import ch.heig_vd.iict.symexercices.R;

/**
 * A {@link AbstractFragment} subclass.
 * Use the {@link AbstractFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentExercise2 extends AbstractFragment {

    private int seekBarValue;

    //GUI elements
    private ProgressBar progressBar = null;
    private Button      pbButton    = null;

    private SeekBar     seekBar     = null;
    private TextView    sbText      = null;

    private CheckBox    cbChoice1   = null;
    private CheckBox    cbChoice2   = null;
    private Button      cbButton    = null;

    private RadioGroup  rbChoice    = null;

    private Spinner     spinner     = null;

    private Boolean spinnerTouched = false;

    public FragmentExercise2() { /*Required empty public constructor*/ }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_exercise2, container, false);

        //we link GUI elements
        this.progressBar = (ProgressBar) v.findViewById(R.id.ex2_pb);
        this.pbButton = (Button) v.findViewById(R.id.ex2_pb_btn);

        this.sbText = (TextView) v.findViewById(R.id.ex2_sb_tv);
        this.seekBar = (SeekBar) v.findViewById(R.id.ex2_sb);

        this.cbChoice1 = (CheckBox) v.findViewById(R.id.ex2_cb_choice1);
        this.cbChoice2 = (CheckBox) v.findViewById(R.id.ex2_cb_choice2);
        this.cbButton = (Button) v.findViewById(R.id.ex2_cb_validate);

        this.rbChoice = (RadioGroup) v.findViewById(R.id.ex2_rb_val);

        this.spinner = (Spinner) v.findViewById(R.id.ex2_sp);

        //init view
        this.seekBarValue = this.seekBar.getProgress();
        updateSeekBarText();

        //add events
        this.pbButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                //TODO Exercice 2.A (part1)
                //on peut setter la progression de la ProgressBar avec la méthode setProgress
                //on veut incrémenter la progression de 1 unité à chaque clic (max 10)
                progressBar.incrementProgressBy(1);

            }
        });
        this.pbButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View arg0) {
                //TODO Exercice 2.A (part2)
                //on veut remettre à zéro la progression de la ProgressBar sur un long clic sur le bouton
                //-> OnLongClickListener

                progressBar.setProgress(0);
                return true;    // <- set to true
            }
        });


        //TODO Exercice 2.B
        //on peut utiliser un listener du type SeekBar.OnSeekBarChangeListener
        //pour être notifié des interactions utilisateurs
        //on veut mettre à jour la textview sbText - cf. variable seekBarValue
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                // TODO Auto-generated method stub
                sbText.setText(String.valueOf(progress));
            }
        });

        this.cbButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO Exercice 2.C
                //on affichera un message à l'aide de la méthode mListner.displaySnackBar()
                //on fonction des CheckBoxs sélectionnées (0, 1 ou l'autre, les 2).
                mListener.displaySnackBar(String.valueOf((cbChoice1.isChecked() ? 1 : 0) + (cbChoice2.isChecked() ? 1 : 0)));
            }
        });

        //TODO Exercice 2.D
        //on peut utiliser un listener du type OnCheckedChangeListener sur un RadioGroup
        //pour être notifié des interactions utilisateurs
        //on affichera un message à l'aide de la fonction mListner.displaySnackBar("") lors d'un choix
        rbChoice.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = (RadioButton)radioGroup.findViewById(i);
                mListener.displaySnackBar("You choose the " + radioButton.getText().toString());
            }
        });

        //TODO Exercice 2.E
        //on peut utiliser un listener du type OnItemSelectedListener sur un Spinner pour être notifié
        //du choix de l'utilisateur
        //Que faut-il fair pour que le Listener ne soit pas notifié lors de l'initialisation du Spinner ?
        spinner.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                spinnerTouched = true;
                return false;
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (spinnerTouched) {
                    mListener.displaySnackBar("You choose the " + spinner.getSelectedItem().toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return v;
    }

    /*
     *  GUI helpers
     */

    private void updateSeekBarText() {
        this.sbText.setText(getResources().getString(R.string.sct2_sb_val, this.seekBarValue));
    }

}
