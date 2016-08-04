package br.com.yaw.ssjpac.validation;


public interface Validator<Entity> {

	public String validate(Entity e);

}
