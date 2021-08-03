
package com.jambo.common.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class PageRes<T> {
    @ApiModelProperty("页面信息")
    private Pagination pagination;
    @ApiModelProperty("数据")
    private List<T> list;
    private String scrollId;

    public PageRes() {
    }

    public PageRes(PageReq pageReq, Long total, List<T> list) {
        this.pagination = Pagination.builder().current(pageReq.getPageCurrent()).pageSize(pageReq.getPageSize()).total(total).build();
        this.list = list;
    }

    public Pagination getPagination() {
        return this.pagination;
    }

    public List<T> getList() {
        return this.list;
    }

    public String getScrollId() {
        return this.scrollId;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public void setScrollId(String scrollId) {
        this.scrollId = scrollId;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PageRes)) {
            return false;
        } else {
            PageRes<?> other = (PageRes)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$pagination = this.getPagination();
                    Object other$pagination = other.getPagination();
                    if (this$pagination == null) {
                        if (other$pagination == null) {
                            break label47;
                        }
                    } else if (this$pagination.equals(other$pagination)) {
                        break label47;
                    }

                    return false;
                }

                Object this$list = this.getList();
                Object other$list = other.getList();
                if (this$list == null) {
                    if (other$list != null) {
                        return false;
                    }
                } else if (!this$list.equals(other$list)) {
                    return false;
                }

                Object this$scrollId = this.getScrollId();
                Object other$scrollId = other.getScrollId();
                if (this$scrollId == null) {
                    if (other$scrollId != null) {
                        return false;
                    }
                } else if (!this$scrollId.equals(other$scrollId)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof PageRes;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $pagination = this.getPagination();
        result = result * 59 + ($pagination == null ? 43 : $pagination.hashCode());
        Object $list = this.getList();
        result = result * 59 + ($list == null ? 43 : $list.hashCode());
        Object $scrollId = this.getScrollId();
        result = result * 59 + ($scrollId == null ? 43 : $scrollId.hashCode());
        return result;
    }

    public String toString() {
        return "PageRes(pagination=" + this.getPagination() + ", list=" + this.getList() + ", scrollId=" + this.getScrollId() + ")";
    }
}
