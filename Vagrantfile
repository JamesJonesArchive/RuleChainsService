VAGRANTFILE_API_VERSION = "2"
vault_password_file = ENV['DEPLOY_KEY']

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|
  ENV['VAGRANT_DEFAULT_PROVIDER'] = 'docker'
  # config.vm.box = "tknerr/baseimage-ubuntu-16.04"
  # config.vm.box_version = "1.0.0"
  config.vm.box = "minimum/centos-7-docker"
  config.vm.box_version = "1.1.4"
  config.vm.hostname = "ubuntu.rulechains.dev"
  # Set the name of the VM. See: http://stackoverflow.com/a/17864388/100134
  config.vm.define "rulechainsservice" do |vm|
  end

  config.vm.network "forwarded_port", guest: 22, host: 2201
  config.vm.network "forwarded_port", guest: 80, host: 8001
  config.vm.network "forwarded_port", guest: 3000, host: 3001 
  config.ssh.username = "vagrant"
  config.vm.network :private_network, type: "dhcp"
  # Configure the Docker provider for Vagrant
  config.vm.provider "docker" do |d|
    d.name = "rulechainsservice"
    d.ports = ['2201:22','8001:80', '3001:3000']
  end
  config.vm.provision :ansible do |ansible|
    ansible.playbook = "ansible/playbook.yml"
    ansible.become = true
    ansible.verbose = "vvv"
    ansible.vault_password_file = vault_password_file
    ansible.groups = {
      "rulechains" => ["rulechainsservice"]
    }
    ansible.extra_vars = {
      remote_user: "vagrant",
      target_hosts: "rulechains"
    }
    ansible.tags = "deploy"
  end
end