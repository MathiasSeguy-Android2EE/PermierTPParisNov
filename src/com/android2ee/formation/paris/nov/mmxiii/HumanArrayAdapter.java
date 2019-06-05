/**<ul>
 * <li>PermierTPParisNov</li>
 * <li>com.android2ee.formation.paris.nov.mmxiii</li>
 * <li>18 nov. 2013</li>
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

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android2ee.formation.paris.nov.mmxiii.transverse.Human;

/**
 * @author Mathias Seguy (Android2EE)
 * @goals
 *        This class aims to:
 *        <ul>
 *        <li></li>
 *        </ul>
 */
public class HumanArrayAdapter extends ArrayAdapter<Human> {
	LayoutInflater inflater;

	/**
	 * @param context
	 * @param resource
	 */
	public HumanArrayAdapter(Context context, ArrayList<Human> data) {
		super(context, R.layout.item_human_odd, data);
		inflater = LayoutInflater.from(context);
	}

	// Always declare temp variables as private static
	private static View rowview;
	private static Human human;
	private static ViewHolder viewHolder;
	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.ArrayAdapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		human = getItem(position);
		rowview = convertView;
		if (null == rowview) {
			if(getItemViewType(position)==0) {
				rowview = inflater.inflate(R.layout.item_human_odd, null);
			}else {
				rowview = inflater.inflate(R.layout.item_human_even, null);
			}
			viewHolder =new ViewHolder(rowview);
			rowview.setTag(viewHolder);
		}
		//row!=null et rowView.getTag==ViewHolder
		viewHolder=(ViewHolder) rowview.getTag();
		viewHolder.getImvPicture().setBackgroundResource(human.getPictureId());
		viewHolder.getTxvName().setText(human.getName());
		viewHolder.getTxvMessage().setText(human.getMessage());
		return rowview;
	}
	
	
/******************************************************************************************/
/** Managing odd and even row **************************************************************************/
/******************************************************************************************/


	/* (non-Javadoc)
	 * @see android.widget.BaseAdapter#getItemViewType(int)
	 */
	@Override
	public int getItemViewType(int position) {
		return position%2;
	}


	/* (non-Javadoc)
	 * @see android.widget.BaseAdapter#getViewTypeCount()
	 */
	@Override
	public int getViewTypeCount() {
		return 2;
	}


	/******************************************************************************************/
	/** The ViewHolder pattern **************************************************************************/
	/******************************************************************************************/

	private class ViewHolder {
		View rowview;
		TextView txvName;
		TextView txvMessage;
		ImageView imvPicture;

		/**
		 * @param rowview
		 */
		private ViewHolder(View rowview) {
			super();
			this.rowview = rowview;
		}

		/**
		 * @return the txvName
		 */
		public final TextView getTxvName() {
			if (null == txvName) {
				txvName = (TextView) rowview.findViewById(R.id.txv_name);
			}
			return txvName;
		}

		/**
		 * @return the txvMessage
		 */
		public final TextView getTxvMessage() {
			if (null == txvMessage) {
				txvMessage = (TextView) rowview.findViewById(R.id.txv_message);
			}
			return txvMessage;
		}

		/**
		 * @return the imvPicture
		 */
		public final ImageView getImvPicture() {
			if (null == imvPicture) {
				imvPicture = (ImageView) rowview.findViewById(R.id.imv_picture);
			}
			return imvPicture;
		}

	}
}
