package fr.maxlego08.menu.button;

import org.bukkit.entity.Player;

import fr.maxlego08.menu.api.button.Button;
import fr.maxlego08.menu.api.button.PermissibleButton;

public abstract class ZPermissibleButton extends ZButton implements PermissibleButton {

	private String permission;
	private Button elseButton;

	@Override
	public Button getElseButton() {
		return this.elseButton;
	}

	@Override
	public String getPermission() {
		return this.permission;
	}

	@Override
	public boolean hasPermission() {
		return this.permission != null;
	}

	@Override
	public boolean hasElseButton() {
		return this.elseButton != null;
	}

	@Override
	public boolean checkPermission(Player player) {
		return this.permission == null || player.hasPermission(this.permission);
	}

	/**
	 * @param permission
	 *            the permission to set
	 */
	public void setPermission(String permission) {
		this.permission = permission;
	}

	/**
	 * @param elseButton
	 *            the elseButton to set
	 */
	public void setElseButton(Button elseButton) {
		this.elseButton = elseButton;
	}

}