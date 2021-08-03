//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.jambo.common.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class PageReq {
    @ApiModelProperty("第几页")
    private int pageCurrent = 1;
    @ApiModelProperty("每页条数")
    private int pageSize = 10;
    @ApiModelProperty("排序列")
    private String sortField = null;
    @ApiModelProperty("顺序")
    private String sortOrder = null;

    public int limit() {
        return this.getPageSize() > 100 ? 100 : this.getPageSize();
    }

    public int offset() {
        return (this.getPageCurrent() - 1) * this.limit();
    }

    public PageReq() {
    }

    public int getPageCurrent() {
        return this.pageCurrent;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public String getSortField() {
        return this.sortField;
    }

    public String getSortOrder() {
        return this.sortOrder;
    }

    public void setPageCurrent(int pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PageReq)) {
            return false;
        } else {
            PageReq other = (PageReq)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getPageCurrent() != other.getPageCurrent()) {
                return false;
            } else if (this.getPageSize() != other.getPageSize()) {
                return false;
            } else {
                label40: {
                    Object this$sortField = this.getSortField();
                    Object other$sortField = other.getSortField();
                    if (this$sortField == null) {
                        if (other$sortField == null) {
                            break label40;
                        }
                    } else if (this$sortField.equals(other$sortField)) {
                        break label40;
                    }

                    return false;
                }

                Object this$sortOrder = this.getSortOrder();
                Object other$sortOrder = other.getSortOrder();
                if (this$sortOrder == null) {
                    if (other$sortOrder != null) {
                        return false;
                    }
                } else if (!this$sortOrder.equals(other$sortOrder)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof PageReq;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + this.getPageCurrent();
        result = result * 59 + this.getPageSize();
        Object $sortField = this.getSortField();
        result = result * 59 + ($sortField == null ? 43 : $sortField.hashCode());
        Object $sortOrder = this.getSortOrder();
        result = result * 59 + ($sortOrder == null ? 43 : $sortOrder.hashCode());
        return result;
    }

    public String toString() {
        return "PageReq(pageCurrent=" + this.getPageCurrent() + ", pageSize=" + this.getPageSize() + ", sortField=" + this.getSortField() + ", sortOrder=" + this.getSortOrder() + ")";
    }
}
