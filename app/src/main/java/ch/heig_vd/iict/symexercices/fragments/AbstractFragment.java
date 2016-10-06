package ch.heig_vd.iict.symexercices.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AbstractFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public abstract class AbstractFragment extends Fragment {

    private static final String TAG = AbstractFragment.class.getSimpleName();

    private static final String ARG_SECTION_NAME = "ARG_SCT_NAME";

    protected OnFragmentInteractionListener mListener = null;
    protected String sectionName = null;

    public AbstractFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param sectionName The tab section name
     * @return A new instance of fragment FragmentExercise1.
     */
    public static AbstractFragment newInstance(Class<? extends AbstractFragment> type, String sectionName) {
        try {
            //Fragment should have the default constructor
            AbstractFragment fragment = type.getConstructor().newInstance();
            Bundle args = new Bundle();
            args.putString(ARG_SECTION_NAME, sectionName);
            fragment.setArguments(args);
            return fragment;
        } catch(Exception e) {
            Log.e(TAG, "Error while instantiating the Fragment", e);
            return null;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.sectionName = getArguments().getString(ARG_SECTION_NAME, "unknown");
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void displaySnackBar(String message);
    }
}
