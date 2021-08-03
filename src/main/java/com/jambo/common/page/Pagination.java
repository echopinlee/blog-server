
package com.jambo.common.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Pagination {
    @ApiModelProperty("当前页数")
    private int current = 1;
    @ApiModelProperty("每页条数")
    private int pageSize = 10;
    @ApiModelProperty("总条数")
    private long total = 0L;

    public static Pagination.PaginationBuilder builder() {
        return new Pagination.PaginationBuilder();
    }

    public int getCurrent() {
        return this.current;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public long getTotal() {
        return this.total;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Pagination)) {
            return false;
        } else {
            Pagination other = (Pagination)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getCurrent() != other.getCurrent()) {
                return false;
            } else if (this.getPageSize() != other.getPageSize()) {
                return false;
            } else {
                return this.getTotal() == other.getTotal();
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof Pagination;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + this.getCurrent();
        result = result * 59 + this.getPageSize();
        long $total = this.getTotal();
        result = result * 59 + (int)($total >>> 32 ^ $total);
        return result;
    }

    public String toString() {
        return "Pagination(current=" + this.getCurrent() + ", pageSize=" + this.getPageSize() + ", total=" + this.getTotal() + ")";
    }

    public Pagination() {
    }

    public Pagination(int current, int pageSize, long total) {
        this.current = current;
        this.pageSize = pageSize;
        this.total = total;
    }

    public static class PaginationBuilder {
        private int current;
        private int pageSize;
        private long total;

        PaginationBuilder() {
        }

        public Pagination.PaginationBuilder current(int current) {
            this.current = current;
            return this;
        }

        public Pagination.PaginationBuilder pageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Pagination.PaginationBuilder total(long total) {
            this.total = total;
            return this;
        }

        public Pagination build() {
            return new Pagination(this.current, this.pageSize, this.total);
        }

        public String toString() {
            return "Pagination.PaginationBuilder(current=" + this.current + ", pageSize=" + this.pageSize + ", total=" + this.total + ")";
        }
    }
}
