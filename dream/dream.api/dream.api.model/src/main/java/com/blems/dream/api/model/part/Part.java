package com.blems.dream.api.model.part;

import org.apache.ibatis.type.Alias;

import com.blems.dream.api.model.DefaultModel;
import com.blems.dream.api.model.bom.Bom;
import com.blems.dream.api.model.coa.ChartAccount;
import com.blems.dream.api.model.common.ObjectType;
import com.blems.dream.api.model.product.Product;
import com.blems.dream.api.model.uom.Uom;

@Alias("Part")
public class Part extends DefaultModel {
	private static final long serialVersionUID = 1L;

	private String num;
	private String description;
	private String details;
	private String upc;
	private String abcCode;
	private String url;
	private ObjectType type;
	
	private ChartAccount cogsAccount;
	private ChartAccount inventoryAccount;
	private ChartAccount crapAccount;
	private ChartAccount adjustmentAccount;
	private ChartAccount varianceAccount;
	
	private Product defaultProduct;
	private Bom defaultBom;
	private Uom uom;
	private String alertNote;
	private float len;
	private float width;
	private float height;
	private Uom sizeUom;
	private float weight;
	private Uom weightUom;
	private boolean alwaysManufactureFlag;
	private boolean pickedInUomFlag;
	private float stdCost;

	
	public Part() {
	
	}
	
	public Part(int id) {
		super(id);
	}
	
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public String getAbcCode() {
		return abcCode;
	}

	public void setAbcCode(String abcCode) {
		this.abcCode = abcCode;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	public ObjectType getType() {
		return type;
	}

	public void setType(ObjectType type) {
		this.type = type;
	}

	public ChartAccount getCogsAccount() {
		return cogsAccount;
	}

	public void setCogsAccount(ChartAccount cogsAccount) {
		this.cogsAccount = cogsAccount;
	}

	public ChartAccount getInventoryAccount() {
		return inventoryAccount;
	}

	public void setInventoryAccount(ChartAccount inventoryAccount) {
		this.inventoryAccount = inventoryAccount;
	}

	public ChartAccount getCrapAccount() {
		return crapAccount;
	}

	public void setCrapAccount(ChartAccount crapAccount) {
		this.crapAccount = crapAccount;
	}

	public ChartAccount getAdjustmentAccount() {
		return adjustmentAccount;
	}

	public void setAdjustmentAccount(ChartAccount adjustmentAccount) {
		this.adjustmentAccount = adjustmentAccount;
	}

	public ChartAccount getVarianceAccount() {
		return varianceAccount;
	}

	public void setVarianceAccount(ChartAccount varianceAccount) {
		this.varianceAccount = varianceAccount;
	}

	public Product getDefaultProduct() {
		return defaultProduct;
	}

	public void setDefaultProduct(Product defaultProduct) {
		this.defaultProduct = defaultProduct;
	}

	public Bom getDefaultBom() {
		return defaultBom;
	}

	public void setDefaultBom(Bom defaultBom) {
		this.defaultBom = defaultBom;
	}

	public Uom getUom() {
		return uom;
	}

	public void setUom(Uom uom) {
		this.uom = uom;
	}

	public String getAlertNote() {
		return alertNote;
	}

	public void setAlertNote(String alertNote) {
		this.alertNote = alertNote;
	}

	public float getLen() {
		return len;
	}

	public void setLen(float len) {
		this.len = len;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public Uom getSizeUom() {
		return sizeUom;
	}

	public void setSizeUom(Uom sizeUom) {
		this.sizeUom = sizeUom;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public Uom getWeightUom() {
		return weightUom;
	}

	public void setWeightUom(Uom weightUom) {
		this.weightUom = weightUom;
	}

	public boolean isAlwaysManufactureFlag() {
		return alwaysManufactureFlag;
	}

	public void setAlwaysManufactureFlag(boolean alwaysManufactureFlag) {
		this.alwaysManufactureFlag = alwaysManufactureFlag;
	}

	public boolean isPickedInUomFlag() {
		return pickedInUomFlag;
	}

	public void setPickedInUomFlag(boolean pickedInUomFlag) {
		this.pickedInUomFlag = pickedInUomFlag;
	}

	public float getStdCost() {
		return stdCost;
	}

	public void setStdCost(float stdCost) {
		this.stdCost = stdCost;
	}

}
