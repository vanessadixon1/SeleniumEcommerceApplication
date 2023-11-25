package com.amcsoftware.parameters.jsonDataItem;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class OrderDataJson{

	@SerializedName("OrderData")
	private List<OrderDataItem> orderData;

	public List<OrderDataItem> getOrderData(){
		return orderData;
	}
}