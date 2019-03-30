package com.rkcpinfo.promotionservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Promotion {
    public Promotion(Long id, Long productId, String promoText) {
		this.id=id;
		this.productId=productId;
		this.promoText=promoText;
	}
	private Long id;
    private Long productId;
    private String promoText;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getPromoText() {
		return promoText;
	}
	public void setPromoText(String promoText) {
		this.promoText = promoText;
	}
    
}
