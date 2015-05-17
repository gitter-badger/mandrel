package io.mandrel.monitor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Infos implements Serializable {
	private static final long serialVersionUID = 3436344116385574896L;

	private long pid;
	private String fqdn;
	private String hostname;
	private double uptime;

	private Cpu cpu = new Cpu();
	private Mem mem = new Mem();
	private Swap swap = new Swap();
	private List<Interface> interfaces = new ArrayList<>(2);
	private Limits limits = new Limits();

	@Data
	public static class Cpu implements Serializable {
		private static final long serialVersionUID = 8512684069342496081L;

		private long sys;
		private long total;
		private long user;
	}

	@Data
	public static class Mem implements Serializable {
		private static final long serialVersionUID = -8797648466105477814L;

		private long total;
		private long used;
		private long free;
	}

	@Data
	public static class Swap implements Serializable {
		private static final long serialVersionUID = 1409517375142998802L;

		private long total;
		private long used;
		private long free;
	}

	@Data
	public static class Interface implements Serializable {
		private static final long serialVersionUID = 49989037162348232L;

		private String name;
		private String type;
		private String address;
	}

	@Data
	public static class Limits implements Serializable {
		private static final long serialVersionUID = 7797483638794413832L;

		private Limit openfiles = new Limit();
		private Limit cpu = new Limit();
		private Limit mem = new Limit();
		private Limit data = new Limit();
		private Limit core = new Limit();
		private Limit filesize = new Limit();
	}

	@Data
	public static class Limit implements Serializable {
		private static final long serialVersionUID = -7149858217513420363L;

		private long current;
		private long max;
	}
}