package com.marc.excelTransformer;

import com.opencsv.bean.CsvBindByName;

public class DataSetModified{

	@CsvBindByName(column = "ordernumber", required = false)
	private String ordernumber;

	@CsvBindByName(column = "mainnumber", required = false)
	private String mainnumber;

	@CsvBindByName(column = "additionalText", required = false)
	private String additionalText;

	@CsvBindByName(column = "name", required = false)
	private String name;
	
	@CsvBindByName(column = "supplier", required = false)
	private String supplier;

	@CsvBindByName(column = "tax", required = false)
	private String tax;

	@CsvBindByName(column = "price_EK", required = false)
	private String price_EK;

	@CsvBindByName(column = "pseudoprice_EK", required = false)
	private String pseudoprice_EK;

	@CsvBindByName(column = "baseprice_EK", required = false)
	private String baseprice_EK;

	@CsvBindByName(column = "price_H", required = false)
	private String price_H;

	@CsvBindByName(column = "pseudoprice_H", required = false)
	private String pseudoprice_H;

	@CsvBindByName(column = "baseprice_H", required = false)
	private String baseprice_H;

	@CsvBindByName(column = "active", required = false)
	private String active;
	
	@CsvBindByName(column = "??", required = false)
	private String u;

	@CsvBindByName(column = "instock", required = false)
	private int instock;

	@CsvBindByName(column = "stockmin", required = false)
	private String stockmin;
	
	@CsvBindByName(column = "description", required = false)
	private String description;

	@CsvBindByName(column = "description_long", required = false)
	private String description_long;

	@CsvBindByName(column = "shippingtime", required = false)
	private String shippingtime;
	
	@CsvBindByName(column = "added", required = false)
	private String added;

	@CsvBindByName(column = "changed", required = false)
	private String changed;

	@CsvBindByName(column = "releasedate", required = false)
	private String releasedate;

	@CsvBindByName(column = "shippingfree", required = false)
	private String shippingfree;

	@CsvBindByName(column = "topseller", required = false)
	private String topseller;

	@CsvBindByName(column = "keywords", required = false)
	private String keywords;

	@CsvBindByName(column = "minpurchase", required = false)
	private String minpurchase;

	@CsvBindByName(column = "purchasesteps", required = false)
	private String purchasesteps;

	@CsvBindByName(column = "maxpurchase", required = false)
	private String maxpurchase;

	@CsvBindByName(column = "purchaseunit", required = false)
	private String purchaseunit;

	@CsvBindByName(column = "referenceunit", required = false)
	private String referenceunit;	
	
	@CsvBindByName(column = "packunit", required = false)
	private String packunit;

	@CsvBindByName(column = "unitID", required = false)
	private String unitID;

	@CsvBindByName(column = "pricegroupID", required = false)
	private String pricegroupID;

	@CsvBindByName(column = "pricegroupActive", required = false)
	private String pricegroupActive;

	@CsvBindByName(column = "laststock", required = false)
	private String laststock;

	@CsvBindByName(column = "suppliernumber", required = false)
	private String suppliernumber;

	@CsvBindByName(column = "weight", required = false)
	private String weight;

	@CsvBindByName(column = "width", required = false)
	private String width;

	@CsvBindByName(column = "height", required = false)
	private String height;

	@CsvBindByName(column = "length", required = false)
	private String length;

	@CsvBindByName(column = "ean", required = false)
	private String ean;

	@CsvBindByName(column = "similar", required = false)
	private String similar;

	@CsvBindByName(column = "configuratorsetID", required = false)
	private String configuratorsetID;

	@CsvBindByName(column = "configuratortype", required = false)
	private String configuratortype;

	@CsvBindByName(column = "configuratorOptions", required = false)
	private String configuratorOptions;

	@CsvBindByName(column = "categories", required = false)
	private String categories;

	@CsvBindByName(column = "propertyGroupName", required = false)
	private String propertyGroupName;

	@CsvBindByName(column = "propertyValueName", required = false)
	private String propertyValueName;

	@CsvBindByName(column = "accessory", required = false)
	private String accessory;

	@CsvBindByName(column = "imageUrl", required = false)
	private String imageUrl;

	@CsvBindByName(column = "main", required = false)
	private String main;

	@CsvBindByName(column = "attr1", required = false)
	private String attr1;

	@CsvBindByName(column = "attr2", required = false)
	private String attr2;

	@CsvBindByName(column = "attr3", required = false)
	private String attr3;

	@CsvBindByName(column = "purchasePrice", required = false)
	private String purchasePrice;

	@CsvBindByName(column = "metatitle", required = false)
	private String metatitle;
	

	public String getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}

	public String getMainnumber() {
		return mainnumber;
	}

	public void setMainnumber(String mainnumber) {
		this.mainnumber = mainnumber;
	}

	public String getAdditionalText() {
		return additionalText;
	}

	public void setAdditionalText(String additionalText) {
		this.additionalText = additionalText;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getPrice_EK() {
		return price_EK;
	}

	public void setPrice_EK(String price_EK) {
		this.price_EK = price_EK;
	}

	public String getPseudoprice_EK() {
		return pseudoprice_EK;
	}

	public void setPseudoprice_EK(String pseudoprice_EK) {
		this.pseudoprice_EK = pseudoprice_EK;
	}

	public String getBaseprice_EK() {
		return baseprice_EK;
	}

	public void setBaseprice_EK(String baseprice_EK) {
		this.baseprice_EK = baseprice_EK;
	}

	public String getPrice_H() {
		return price_H;
	}

	public void setPrice_H(String price_H) {
		this.price_H = price_H;
	}

	public String getPseudoprice_H() {
		return pseudoprice_H;
	}

	public void setPseudoprice_H(String pseudoprice_H) {
		this.pseudoprice_H = pseudoprice_H;
	}

	public String getBaseprice_H() {
		return baseprice_H;
	}

	public void setBaseprice_H(String baseprice_H) {
		this.baseprice_H = baseprice_H;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getUnknown() {
		return u;
	}

	public void setUnknown(String unknown) {
		this.u = unknown;
	}

	public int getInstock() {
		return instock;
	}

	public void setInstock(int instock) {
		this.instock = instock;
	}

	public String getStockmin() {
		return stockmin;
	}

	public void setStockmin(String stockmin) {
		this.stockmin = stockmin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription_long() {
		return description_long;
	}

	public void setDescription_long(String descrption_long) {
		this.description_long = descrption_long;
	}

	public String getShippingtime() {
		return shippingtime;
	}

	public void setShippingtime(String shippingtime) {
		this.shippingtime = shippingtime;
	}

	public String getAdded() {
		return added;
	}

	public void setAdded(String added) {
		this.added = added;
	}

	public String getChanged() {
		return changed;
	}

	public void setChanged(String changed) {
		this.changed = changed;
	}

	public String getReleasedate() {
		return releasedate;
	}

	public void setReleasedate(String releasedate) {
		this.releasedate = releasedate;
	}

	public String getShippingfree() {
		return shippingfree;
	}

	public void setShippingfree(String shippingfree) {
		this.shippingfree = shippingfree;
	}

	public String getTopseller() {
		return topseller;
	}

	public void setTopseller(String topseller) {
		this.topseller = topseller;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getMinpurchase() {
		return minpurchase;
	}

	public void setMinpurchase(String minpurchase) {
		this.minpurchase = minpurchase;
	}

	public String getPurchasesteps() {
		return purchasesteps;
	}

	public void setPurchasesteps(String purchasesteps) {
		this.purchasesteps = purchasesteps;
	}

	public String getMaxpurchase() {
		return maxpurchase;
	}

	public void setMaxpurchase(String maxpurchase) {
		this.maxpurchase = maxpurchase;
	}

	public String getPurchaseunit() {
		return purchaseunit;
	}

	public void setPurchaseunit(String purchaseunit) {
		this.purchaseunit = purchaseunit;
	}

	public String getPackunit() {
		return packunit;
	}

	public void setPackunit(String packunit) {
		this.packunit = packunit;
	}

	public String getUnitID() {
		return unitID;
	}

	public void setUnitID(String unitID) {
		this.unitID = unitID;
	}

	public String getPricegroupID() {
		return pricegroupID;
	}

	public void setPricegroupID(String pricegroupID) {
		this.pricegroupID = pricegroupID;
	}

	public String getPricegroupActive() {
		return pricegroupActive;
	}

	public void setPricegroupActive(String pricegroupActive) {
		this.pricegroupActive = pricegroupActive;
	}

	public String getLaststock() {
		return laststock;
	}

	public void setLaststock(String laststock) {
		this.laststock = laststock;
	}

	public String getSuppliernumber() {
		return suppliernumber;
	}

	public void setSuppliernumber(String suppliernumber) {
		this.suppliernumber = suppliernumber;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public String getSimilar() {
		return similar;
	}

	public void setSimilar(String similiar) {
		this.similar = similiar;
	}

	public String getConfiguratorsetID() {
		return configuratorsetID;
	}

	public void setConfiguratorsetID(String configuratorsetID) {
		this.configuratorsetID = configuratorsetID;
	}

	public String getConfiguratortype() {
		return configuratortype;
	}

	public void setConfiguratortype(String configuratortype) {
		this.configuratortype = configuratortype;
	}

	public String getConfiguratorOptions() {
		return configuratorOptions;
	}

	public void setConfiguratorOptions(String configuratorOptions) {
		this.configuratorOptions = configuratorOptions;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getPropertyGroupName() {
		return propertyGroupName;
	}

	public void setPropertyGroupName(String propertyGroupName) {
		this.propertyGroupName = propertyGroupName;
	}

	public String getPropertyValueName() {
		return propertyValueName;
	}

	public void setPropertyValueName(String propertyValueName) {
		this.propertyValueName = propertyValueName;
	}

	public String getAccessory() {
		return accessory;
	}

	public void setAccessory(String accessory) {
		this.accessory = accessory;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getAttr1() {
		return attr1;
	}

	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}

	public String getAttr2() {
		return attr2;
	}

	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}

	public String getAttr3() {
		return attr3;
	}

	public void setAttr3(String attr3) {
		this.attr3 = attr3;
	}

	public String getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public String getMetatitle() {
		return metatitle;
	}

	public void setMetatitle(String metatitle) {
		this.metatitle = metatitle;
	}

	@Override
	public String toString() {
		return "DataSetModified [ordernumber=" + ordernumber + ", mainnumber=" + mainnumber + ", additionalText="
				+ additionalText + ", name=" + name + ", supplier=" + supplier + ", tax=" + tax + ", price_EK="
				+ price_EK + ", pseudoprice_EK=" + pseudoprice_EK + ", baseprice_EK=" + baseprice_EK + ", price_H="
				+ price_H + ", pseudoprice_H=" + pseudoprice_H + ", baseprice_H=" + baseprice_H + ", active=" + active
				+ ", u=" + u + ", instock=" + instock + ", stockmin=" + stockmin + ", description="
				+ description + ", description_long=" + description_long + ", shippingtime=" + shippingtime + ", added="
				+ added + ", changed=" + changed + ", releasedate=" + releasedate + ", shippingfree=" + shippingfree
				+ ", topseller=" + topseller + ", keywords=" + keywords + ", minpurchase=" + minpurchase
				+ ", purchasesteps=" + purchasesteps + ", maxpurchase=" + maxpurchase + ", purchaseunit=" + purchaseunit
				+ ", packunit=" + packunit + ", unitID=" + unitID + ", pricegroupID=" + pricegroupID
				+ ", pricegroupActive=" + pricegroupActive + ", laststock=" + laststock + ", suppliernumber="
				+ suppliernumber + ", weight=" + weight + ", width=" + width + ", height=" + height + ", length="
				+ length + ", ean=" + ean + ", similar=" + similar + ", configuratorsetID=" + configuratorsetID
				+ ", configuratortype=" + configuratortype + ", configuratorOptions=" + configuratorOptions
				+ ", categories=" + categories + ", propertyGroupName=" + propertyGroupName + ", propertyValueName="
				+ propertyValueName + ", accessory=" + accessory + ", imageUrl=" + imageUrl + ", main=" + main
				+ ", attr1=" + attr1 + ", attr2=" + attr2 + ", attr3=" + attr3 + ", purchasePrice=" + purchasePrice
				+ ", metatitle=" + metatitle + "]";
	}

	public String getReferenceunit() {
		return referenceunit;
	}

	public void setReferenceunit(String referenceunit) {
		this.referenceunit = referenceunit;
	}


	
	


	

}
