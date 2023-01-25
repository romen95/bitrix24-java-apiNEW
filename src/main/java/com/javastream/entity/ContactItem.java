package com.javastream.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;

/**
 * Contact.
 *
 * UPD: name and lastName are mandatory fields for creation a new Contract
 *
 * @author javastream
 */
@Data
@ToString
public class ContactItem {

    public ContactItem(Integer contactId) {
        this.contactId = contactId;
    }

    @SerializedName("CONTACT_ID")
    private Integer contactId;

    @SerializedName("SORT")
    private Integer sort;

    @SerializedName("IS_PRIMARY")
    private Character isPrimary;
}