/**<ul>
 * <li>PermierTPParisNov</li>
 * <li>com.android2ee.formation.paris.nov.mmxiii.transverse</li>
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
package com.android2ee.formation.paris.nov.mmxiii.transverse;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Mathias Seguy (Android2EE)
 * @goals
 *        This class aims to:
 *        <ul>
 *        <li></li>
 *        </ul>
 */
public class Human implements Parcelable{
	String name;
	String message;
	int pictureId;

	/**
	 * @param name
	 * @param message
	 * @param pictureId
	 */
	public Human(String name, String message, int pictureId) {
		super();
		this.name = name;
		this.message = message;
		this.pictureId = pictureId;
	}

	/**
	 * @return the name
	 */
	public final String getName() {

		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the message
	 */
	public final String getMessage() {

		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public final void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the pictureId
	 */
	public final int getPictureId() {

		return pictureId;
	}

	/**
	 * @param pictureId
	 *            the pictureId to set
	 */
	public final void setPictureId(int pictureId) {
		this.pictureId = pictureId;
	}


    protected Human(Parcel in) {
        name = in.readString();
        message = in.readString();
        pictureId = in.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(message);
        dest.writeInt(pictureId);
    }

    public static final Parcelable.Creator<Human> CREATOR = new Parcelable.Creator<Human>() {
        public Human createFromParcel(Parcel in) {
            return new Human(in);
        }

        public Human[] newArray(int size) {
            return new Human[size];
        }
    };
}
