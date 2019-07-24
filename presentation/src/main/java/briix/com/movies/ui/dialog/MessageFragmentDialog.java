package briix.com.movies.ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import androidx.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.appcompat.content.res.AppCompatResources;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import briix.com.movies.R;
import briix.com.movies.databinding.DialogMessageBinding;


public class MessageFragmentDialog extends AppCompatDialogFragment {

    public static final String TAG_FRAGMENT_NO_NETWORK = "Dialog No Network";

    public static final String ALERT_IMAGE_CONTAINER = "alert_image_container";
    public static final String ALERT_TITLE = "alert_title";
    public static final String ALERT_CONTENT = "alert_content";
    public static final String ACCEPT_BUTTON_TEXT = "accept_button_text";
    public static final String CANCEL_BUTTON_TEXT = "cancel_button_text";
    public static final String HINT_TEXT = "hint_text";
    public static final String EDIT_TEXT_ICON = "edt_icon";

    private DialogInterface.OnClickListener dialogClickListener;
    private Dialog dialog;

    private DialogMessageBinding binding;
    private int inputType;
    private String inputPreloadedData;


    public static MessageFragmentDialog newInstance(int icon, String txtTitle, String txtContent, String btnContinue,
                                                    String btnCancel, String hint, int edt_icon) {
        MessageFragmentDialog fragment = new MessageFragmentDialog();
        Bundle args = new Bundle();
        args.putInt(ALERT_IMAGE_CONTAINER, icon);
        args.putString(ALERT_TITLE, txtTitle);
        args.putString(ALERT_CONTENT, txtContent);
        args.putString(ACCEPT_BUTTON_TEXT, btnContinue);
        args.putString(CANCEL_BUTTON_TEXT, btnCancel);
        args.putString(HINT_TEXT, hint);
        args.putInt(EDIT_TEXT_ICON, edt_icon);
        fragment.setArguments(args);

        return fragment;
    }


    public MessageFragmentDialog setBlurInputType(int inputType, String inputPreloadedData) {
        this.inputType = inputType;
        this.inputPreloadedData = inputPreloadedData;
        return this;
    }


    public MessageFragmentDialog setDialogClickListener(DialogInterface.OnClickListener dialogClickListener) {
        this.dialogClickListener = dialogClickListener;
        return this;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        dialogClickListener = null;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        dialog = super.onCreateDialog(savedInstanceState);
        // the content
        final RelativeLayout root = new RelativeLayout(getActivity());
        root.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        // creating the fullscreen dialog
        final Dialog dialog = new Dialog(requireActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(root);

        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        }

        return dialog;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_message, container, false);

        setOnClickListeners();
        loadBundle();
        setCancelable(false);
        initListener();
        return binding.getRoot();
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        FragmentTransaction ft = manager.beginTransaction();
        ft.add(this, tag);
        ft.commitAllowingStateLoss();
    }

    public void setOnClickListeners() {
        binding.textContent.setMovementMethod(LinkMovementMethod.getInstance());
        //binding.textContent.setLinkTextColor(ContextCompat.getColor(requireActivity(), R.color.colorLinkLight));
    }

    private void initListener() {
        binding.buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dialogClickListener != null) {
                    dialogClickListener.onClick(dialog, DialogInterface.BUTTON_POSITIVE);
                    if (getTag() != null && !getTag().equals(TAG_FRAGMENT_NO_NETWORK))
                        dismissAllowingStateLoss();
                } else {
                    dismissAllowingStateLoss();
                }
            }
        });


        binding.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dialogClickListener != null) {
                    dialogClickListener.onClick(dialog, DialogInterface.BUTTON_NEGATIVE);
                    dismissAllowingStateLoss();
                } else {
                    dismissAllowingStateLoss();
                }
            }
        });

        binding.imageClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dialogClickListener != null)
                    dialogClickListener.onClick(dialog, DialogInterface.BUTTON_NEGATIVE);
                dismissAllowingStateLoss();
            }
        });
    }

    public void loadBundle() {
        Bundle bundle = getArguments();
        if (bundle == null) return;

        if (bundle.getInt(ALERT_IMAGE_CONTAINER, 0) > 0)
            binding.imageCircle.setImageDrawable(AppCompatResources.getDrawable(requireActivity(), bundle.getInt(ALERT_IMAGE_CONTAINER)));

        if (bundle.getString(ALERT_TITLE) != null) {
            binding.textTitle.setText(bundle.getString(ALERT_TITLE));
            binding.textTitle.setVisibility(View.VISIBLE);
        }

        if (bundle.getString(ALERT_CONTENT) != null)
            binding.textContent.setText(Html.fromHtml(bundle.getString(ALERT_CONTENT)));
//            binding.textContent.setText(bundle.getString(ALERT_CONTENT));

        if (bundle.getString(CANCEL_BUTTON_TEXT) != null) {
            binding.buttonCancel.setText(bundle.getString(CANCEL_BUTTON_TEXT));
            binding.buttonCancel.setVisibility(View.VISIBLE);
        }

        if (bundle.getString(ACCEPT_BUTTON_TEXT) != null) {
            binding.buttonContinue.setText(bundle.getString(ACCEPT_BUTTON_TEXT));
            binding.buttonContinue.setVisibility(View.VISIBLE);
        }
        int icCloseVisibility = bundle.getString(CANCEL_BUTTON_TEXT) != null && bundle.getString(ACCEPT_BUTTON_TEXT) != null ?
                View.VISIBLE : View.INVISIBLE;

        binding.imageClose.setVisibility(icCloseVisibility);

    }
}

