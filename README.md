# PermissionsManager

PermissionsManager is a Minecraft plugin designed to manage permissions, groups, users, prefixes, and suffixes without the use of external APIs. This plugin is compatible with Spigot and Bukkit servers.

## Features

- **Manage Permissions:** Directly add, remove, or modify user and group permissions.
- **Group Management:** Create, modify, and delete groups with specific permissions.
- **User Management:** Assign users to groups and manage their specific permissions.
- **Prefixes & Suffixes:** Define prefixes and suffixes for groups to display in chat.

## Installation

1. Download the PermissionsManager.jar file.
2. Place the downloaded jar into your server's `plugins` directory.
3. Restart your server.
4. Adjust the `config.yml` as needed to suit your server setup.

## Commands

- `/permissions adduser <user> <permission>` - Adds a permission to a user.
- `/permissions addgroup <user> <group>` - Adds a user to a group.
- `/permissions setprefix <group> <prefix>` - Sets a prefix for a group.
- `/permissions setsuffix <group> <suffix>` - Sets a suffix for a group.

## Configuration

Edit the `config.yml` in the plugin directory to customize default settings.
