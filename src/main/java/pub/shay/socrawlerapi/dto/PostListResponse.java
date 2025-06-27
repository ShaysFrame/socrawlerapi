package pub.shay.socrawlerapi.dto;

import java.util.List;

public class PostListResponse {
	private List<PostDto> posts;
	private long total;
	private int page;
	private int limit;
	private int totalPages;

	// Default constructor
	public PostListResponse() {
	}

	// Constructor
	public PostListResponse(List<PostDto> posts, long total, int page, int limit) {
		this.posts = posts;
		this.total = total;
		this.page = page;
		this.limit = limit;
		this.totalPages = (int) Math.ceil((double) total / limit);
	}

	// Getters and Setters
	public List<PostDto> getPosts() {
		return posts;
	}

	public void setPosts(List<PostDto> posts) {
		this.posts = posts;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
}
