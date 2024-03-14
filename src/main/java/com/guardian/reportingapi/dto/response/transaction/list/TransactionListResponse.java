package com.guardian.reportingapi.dto.response.transaction.list;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class TransactionListResponse {

    private int per_page;
    private int current_page;
    private String next_page_url;
    private String prev_page_url;
    private  int from;
    private int to;
    private List<Data> data;
}
