package com.ruoyi.ecommerce.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品对象 product
 * 
 * @author Chiang
 * @date 2020-12-25
 */
public class Product extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增长ID */
    private Long pkId;

    /** 商品标题 */
    @Excel(name = "商品标题")
    private String title;

    /** 商品原价 */
    @Excel(name = "商品原价")
    private Long originalPrice;

    /** 商品售价 */
    @Excel(name = "商品售价")
    private BigDecimal salePrice;

    /** 商品库存 */
    @Excel(name = "商品库存")
    private Integer stock;

    /** 商品描述 */
    @Excel(name = "商品描述")
    private String des;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String imageUrls;

    public void setPkId(Long pkId) 
    {
        this.pkId = pkId;
    }

    public Long getPkId() 
    {
        return pkId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setOriginalPrice(Long originalPrice) 
    {
        this.originalPrice = originalPrice;
    }

    public Long getOriginalPrice() 
    {
        return originalPrice;
    }
    public void setSalePrice(BigDecimal salePrice) 
    {
        this.salePrice = salePrice;
    }

    public BigDecimal getSalePrice() 
    {
        return salePrice;
    }
    public void setStock(Integer stock) 
    {
        this.stock = stock;
    }

    public Integer getStock() 
    {
        return stock;
    }
    public void setDes(String des) 
    {
        this.des = des;
    }

    public String getDes() 
    {
        return des;
    }
    public void setImageUrls(String imageUrls) 
    {
        this.imageUrls = imageUrls;
    }

    public String getImageUrls() 
    {
        return imageUrls;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("pkId", getPkId())
            .append("title", getTitle())
            .append("originalPrice", getOriginalPrice())
            .append("salePrice", getSalePrice())
            .append("stock", getStock())
            .append("des", getDes())
            .append("imageUrls", getImageUrls())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
