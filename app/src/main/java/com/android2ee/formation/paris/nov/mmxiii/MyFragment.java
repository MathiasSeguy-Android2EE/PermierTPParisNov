/**<ul>
 * <li>PermierTPParisNov</li>
 * <li>com.android2ee.formation.paris.nov.mmxiii</li>
 * <li>22 nov. 2013</li>
 * 
 * <li>======================================================</li>
 *
 * <li>Projet : Mathias Seguy Project</li>
 * <li>Produit par MSE.</li>
 *
 /**
 * <ul>
 * Android Tutorial, An <strong>Android2EE</strong>'s project.</br> 
 * Produced by <strong>Dr. Mathias SEGUY</strong>.</br>
 * Delivered by <strong>http://android2ee.com/</strong></br>
 *  Belongs to <strong>Mathias Seguy</strong></br>
 ****************************************************************************************************************</br>
 * This code is free for any usage but can't be distribute.</br>
 * The distribution is reserved to the site <strong>http://android2ee.com</strong>.</br>
 * The intelectual property belongs to <strong>Mathias Seguy</strong>.</br>
 * <em>http://mathias-seguy.developpez.com/</em></br> </br>
 * 
 * *****************************************************************************************************************</br>
 *  Ce code est libre de toute utilisation mais n'est pas distribuable.</br>
 *  Sa distribution est reservée au site <strong>http://android2ee.com</strong>.</br> 
 *  Sa propriété intellectuelle appartient à <strong>Mathias Seguy</strong>.</br>
 *  <em>http://mathias-seguy.developpez.com/</em></br> </br>
 * *****************************************************************************************************************</br>
 */
package com.android2ee.formation.paris.nov.mmxiii;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.android2ee.formation.paris.nov.mmxiii.transverse.Human;

/**
 * @author Mathias Seguy (Android2EE)
 * @goals
 *        This class aims to:
 *        <ul>
 *        <li></li>
 *        </ul>
 */
public class MyFragment extends Fragment {
	/******************************************************************************************/
	/** Constants **************************************************************************/
	/******************************************************************************************/

	/**
	 * Cst for SaveInstance bundle
	 */
	private static final String LIST = "list";
	/**
	 * Cst for SaveInstance bundle
	 */
	private static final String EDT = "edt";
	/******************************************************************************************/
	/** Attributs **************************************************************************/
	/******************************************************************************************/
	/**
	 * The button add
	 */
	private Button btnAdd;
	/**
	 * The editMessage
	 */
	private EditText edtMessage;
	/**
	 * The LisView
	 */
	private ListView lsvResult;
	/**
	 * The list of items displayed by the listView
	 */
	private ArrayList<Human> messages;
	/**
	 * The arrayAdapter of the listView
	 */
	private HumanArrayAdapter arrayAdapter;
	/**
	 * The position of the selected item in tha ListView
	 */
	private int itemPosition;
	/**
	 * The PopUp Menu
	 */
	private PopupMenu popupMenu;
	/**
	 * The context
	 */
	private Activity ctx;

	/**
	 * 
	 */
	public MyFragment() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see androidx.fragment.app.Fragment#onCreateView(android.view.LayoutInflater,
	 * android.view.ViewGroup, android.os.Bundle)
	 */
	/* (non-Javadoc)
	 * @see androidx.fragment.app.Fragment#onAttach(android.app.Activity)
	 */
	@Override
	public void onAttach(Activity activity) {
		ctx=activity;
		super.onAttach(activity);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment,container,false);
		// instantiate the graphical elements
		btnAdd = (Button) view.findViewById(R.id.btn_add);
		edtMessage = (EditText) view.findViewById(R.id.edt_message);
		// Register the EditText has carrying a MenuItem
		registerForContextMenu(edtMessage);
		// ListView instanciation
		lsvResult = (ListView) view.findViewById(R.id.lsv_result);
		messages = new ArrayList<Human>();
		arrayAdapter = new HumanArrayAdapter(ctx, messages);
		lsvResult.setAdapter(arrayAdapter);
		// create the Popup Menu
		if (getResources().getBoolean(R.bool.postHoneyComb)) {
			addPopUpMenu();
		}
		// Add the listeners
		btnAdd.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				addMessage();
				if (getResources().getBoolean(R.bool.postHoneyComb)) {
					popupMenu.show();
				}
			}
		});
		lsvResult.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				onListItemClicked(position);
			}
		});
		return view;
	}
	/******************************************************************************************/
	/** Private Methods **************************************************************************/
	/******************************************************************************************/

	/**
	 * This method is called when the user click on the Add button
	 */
	private void addMessage() {
		// find the content of EDT_Message and paste it in the TextView txvResult
		String message = edtMessage.getText().toString();

		// 1°méthode
		// messages.add(message);
		// arrayAdapter.notifyDataSetChanged();
		// 2° methode
		Human humanPipo;
		if (messages.size() % 2 == 0) {
			humanPipo = new Human("Charle", message, R.drawable.ic_item_pair);
		} else {
			humanPipo = new Human("Celine", message, R.drawable.ic_item_impair);
		}
		arrayAdapter.add(humanPipo);

		// flush the edittext
		edtMessage.setText("");
	}

	/**
	 * This method is called when the user click on an item of the ListView
	 * 
	 * @param position
	 *            The position of the clicked item
	 */
	private void onListItemClicked(int position) {
		ctx.showDialog(MainActivity.ALERTDIALOG_ID);
		itemPosition = position;
	}

	/**
	 * Copy the selected item to EDT
	 */
	 void copyToEDT() {
		showToast(true);
		Human item = arrayAdapter.getItem(itemPosition);
		edtMessage.setText(item.getMessage());
	}

	/**
	 * Don't copy the selected item to EDT
	 */
	 void dontCopyToEDT() {
		showToast(false);
	}
	/**
	 * Show a Custom Toast
	 */
	private void showToast(boolean userHasAccept) {
		Toast toast = new Toast(ctx);
		toast.setDuration(Toast.LENGTH_LONG);
		LayoutInflater inflater = LayoutInflater.from(ctx);
		View view = inflater.inflate(R.layout.toast_layout, null);
		TextView txvToastMessage = (TextView) view.findViewById(R.id.txv_toast_message);
		if (userHasAccept) {
			txvToastMessage.setText(R.string.toast_success);
		} else {
			txvToastMessage.setText(R.string.toast_refused);
		}
		toast.setView(view);
		toast.show();
	}
	
	/******************************************************************************************/
	/** Managing PopUpMenu **************************************************************************/
	/******************************************************************************************/
	
	/**
	 * Create the PopUp menu
	 */
	private void addPopUpMenu() {
		popupMenu = new PopupMenu(ctx, edtMessage);
		popupMenu.inflate(R.menu.main);
		popupMenu.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				switch (item.getItemId()) {
				case R.id.action_settings:
					// do a stuff
					return true;
				}
				return false;
			}
		});
	}
}
