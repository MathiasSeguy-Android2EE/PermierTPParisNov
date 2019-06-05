package com.android2ee.formation.paris.nov.mmxiii;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {
	/******************************************************************************************/
	/** Constants **************************************************************************/
	/******************************************************************************************/

//	/**
//	 * Cst for SaveInstance bundle
//	 */
//	private static final String LIST = "list";
//	/**
//	 * Cst for SaveInstance bundle
//	 */
//	private static final String EDT = "edt";
	/**
	 * Cst for the alertDialog
	 */
	public static final int ALERTDIALOG_ID = 20081104;
	
	/**
	 * The displayed fragment
	 */
	MyFragment fragment;
	
	/******************************************************************************************/
	/** Managing life cycle **************************************************************************/
	/******************************************************************************************/

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// build the view
		setContentView(R.layout.activity_main);
		FragmentManager fm=getSupportFragmentManager();
		fragment=(MyFragment) fm.findFragmentById(R.id.fragment);
//		// instantiate the graphical elements
//		btnAdd = (Button) findViewById(R.id.btn_add);
//		edtMessage = (EditText) findViewById(R.id.edt_message);
//		// Register the EditText has carrying a MenuItem
//		registerForContextMenu(edtMessage);
//		// ListView instanciation
//		lsvResult = (ListView) findViewById(R.id.lsv_result);
//		messages = new ArrayList<Human>();
//		arrayAdapter = new HumanArrayAdapter(this, messages);
//		lsvResult.setAdapter(arrayAdapter);
//		//create the Popup Menu
//		if(getResources().getBoolean(R.bool.postHoneyComb)) {
//			addPopUpMenu();
//		}
//		// Add the listeners
//		btnAdd.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				addMessage();
//				if(getResources().getBoolean(R.bool.postHoneyComb)) {
//					popupMenu.show();
//				}
//			}
//		});
//		lsvResult.setOnItemClickListener(new OnItemClickListener() {
//			@Override
//			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//				onListItemClicked(position);
//			}
//		});
	}

	/******************************************************************************************/
	/** Managing Rotation change **************************************************************************/
	/******************************************************************************************/
	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onRestoreInstanceState(android.os.Bundle)
	 */
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		// Called to restore data
//		edtMessage.setText(savedInstanceState.getString(EDT));
//		for (Parcelable human : savedInstanceState.getParcelableArrayList(LIST)) {
//			messages.add((Human) human);
//		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onSaveInstanceState(android.os.Bundle)
	 */
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		// Called to save data
//		outState.putString(EDT, edtMessage.getText().toString());
//		outState.putParcelableArrayList(LIST, messages);

	}

	/******************************************************************************************/
	/** AlertDialog Management **************************************************************************/
	/******************************************************************************************/
	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreateDialog(int)
	 */
	@Override
	protected Dialog onCreateDialog(int id) {
		Dialog dialog;
		switch (id) {
		case ALERTDIALOG_ID:
			dialog = buildSimpleAlertDialog();
			break;
		default:
			dialog = super.onCreateDialog(id);
			break;
		}
		return dialog;
	}

	/**
	 * Build a simple AlertDailog
	 * 
	 * @return The AlertDialog
	 */
	private Dialog buildSimpleAlertDialog() {
		AlertDialog.Builder aBuilder = new AlertDialog.Builder(this);
		// The message
		aBuilder.setMessage(getString(R.string.alertdialog_message));
		// The yes button
		aBuilder.setPositiveButton(R.string.alertdialog_yes, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				fragment.copyToEDT();
			}

		});
		aBuilder.setNegativeButton(R.string.alertdialog_no, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				fragment.dontCopyToEDT();
			}

		});
		return aBuilder.create();
	}

	

	
	/******************************************************************************************/
	/** Managing OptionMenu **************************************************************************/
	/******************************************************************************************/

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_settings:
			Toast.makeText(this, "Ok the menuItem Setting has been selected", Toast.LENGTH_LONG).show();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/******************************************************************************************/
	/** Managing ContextMenu **************************************************************************/
	/******************************************************************************************/
	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreateContextMenu(android.view.ContextMenu, android.view.View,
	 * android.view.ContextMenu.ContextMenuInfo)
	 */
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		if (v.getId() == R.id.edt_message) {
			new MenuInflater(this).inflate(R.menu.main, menu);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onContextItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_settings:
			Toast.makeText(this, "Ok the menuItem Setting has been selected", Toast.LENGTH_LONG).show();
			return true;
		}
		return super.onContextItemSelected(item);
	}

	

}
