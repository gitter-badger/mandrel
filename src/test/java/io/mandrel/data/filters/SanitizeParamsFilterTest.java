package io.mandrel.data.filters;

import io.mandrel.data.filters.link.SanitizeParamsFilter;
import io.mandrel.data.spider.Link;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class SanitizeParamsFilterTest {

	private SanitizeParamsFilter filter;

	@Before
	public void beforeEashTest() {
		filter = new SanitizeParamsFilter();
	}

	@Test
	public void no_link() {
		Assertions.assertThat(filter.isValid(new Link())).isTrue();
	}

	@Test
	public void link_without_params() {
		Link link = new Link().setUri("http://localhost/1");
		Assertions.assertThat(filter.isValid(link)).isTrue();
		Assertions.assertThat(link.getUri()).isEqualTo("http://localhost/1");
	}

	@Test
	public void link_without_valid_params() {
		Link link = new Link().setUri("http://localhost/1?");
		Assertions.assertThat(filter.isValid(link)).isTrue();
		Assertions.assertThat(link.getUri()).isEqualTo("http://localhost/1");
	}

	@Test
	public void link_with_param_empty() {
		Link link = new Link().setUri("http://localhost/1?test");
		Assertions.assertThat(filter.isValid(link)).isTrue();
		Assertions.assertThat(link.getUri()).isEqualTo("http://localhost/1");
	}

	@Test
	public void link_with_param_empty_keept() {
		Link link = new Link().setUri("http://localhost/1?test");
		filter.setExclusions(Arrays.asList("test"));
		Assertions.assertThat(filter.isValid(link)).isTrue();
		Assertions.assertThat(link.getUri()).isEqualTo("http://localhost/1?test");
	}

	@Test
	public void link_with_params_all_filtered() {
		Link link = new Link().setUri("http://localhost/1?foo=test&foo2=test2");
		Assertions.assertThat(filter.isValid(link)).isTrue();
		Assertions.assertThat(link.getUri()).isEqualTo("http://localhost/1");
	}

	@Test
	public void link_with_params_and_keep_one() {
		Link link = new Link().setUri("http://localhost/1?foo=test&foo2=test2");
		filter.setExclusions(Arrays.asList("foo2"));
		Assertions.assertThat(filter.isValid(link)).isTrue();
		Assertions.assertThat(link.getUri()).isEqualTo("http://localhost/1?foo2=test2");
	}
	
	@Test
	public void link_with_params_and_keep_mutliple() {
		Link link = new Link().setUri("http://localhost/1?foo=test&foo2=test2&foo2=test3&z=13");
		filter.setExclusions(Arrays.asList("foo2", "foo"));
		Assertions.assertThat(filter.isValid(link)).isTrue();
		Assertions.assertThat(link.getUri()).isEqualTo("http://localhost/1?foo=test&foo2=test2&foo2=test3");
	}

}