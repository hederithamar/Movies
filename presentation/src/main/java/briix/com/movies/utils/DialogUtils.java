package briix.com.movies.utils;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.appcompat.app.AlertDialog;

import briix.com.movies.R;
import briix.com.movies.ui.dialog.MessageFragmentDialog;


public class DialogUtils {

    private static final String TAG = "DialogUtils";
    public static final String TAG_FRAGMENT_DIALOG_BLUR_GENERIC = "Dialog Blur Generic";
    public static final String TAG_FRAGMENT_NO_NETWORK = "Dialog No Network";

    public static AlertDialog showMessageBlurDialogGeneric(FragmentActivity activity, String clave,
                                                           String title, String message,
                                                           String acceptText, String cancelText,
                                                           DialogInterface.OnClickListener listener) {

        if (clave.equals("401") || clave.equals("404") || clave.equals("500")) {
            return showMessageBlurDialogGeneric(activity, title, message,
                    acceptText, null, listener, R.drawable.ic_dialog_info);
        } else {
            return showMessageBlurDialogGeneric(activity, title, message,
                    acceptText, cancelText, listener, R.drawable.ic_dialog_info);
        }

    }

    public static AlertDialog showMessageBlurDialogGeneric(FragmentActivity activity, String title, String message,
                                                           String acceptText, String cancelText,
                                                           DialogInterface.OnClickListener listener, int icon) {
        MessageFragmentDialog messageFragmentDialog =
                (MessageFragmentDialog) activity.getSupportFragmentManager().findFragmentByTag(TAG_FRAGMENT_DIALOG_BLUR_GENERIC);

        if (messageFragmentDialog == null)
            MessageFragmentDialog.newInstance(icon, title, message, acceptText, cancelText, null, 0)
                    .setDialogClickListener(listener)
                    .show(activity.getSupportFragmentManager(), TAG_FRAGMENT_DIALOG_BLUR_GENERIC);
        else
            messageFragmentDialog.setDialogClickListener(listener);

        return null;
    }
}

