#!/usr/bin/python3.8

import re, sys
import xml.dom.minidom as MD
import xml.etree.ElementTree as ET

def clean(xmlStr, header):
    xmlStr = re.sub('[\n|\t]', '', xmlStr)
    xmlStr = re.sub(' +', ' ', xmlStr)
    xmlStr = re.sub('> <', '><', xmlStr)
    xmlStr = re.sub(header, '<root>', xmlStr)
    xmlStr = re.sub('<\?xml*>', '', xmlStr)
    return re.sub('</project>', '</root>', xmlStr)

def addArtifactElemen(parent, arr):
    groupId = ET.SubElement(parent, "groupId")
    artifactId = ET.SubElement(parent, "artifactId")
    version = ET.SubElement(parent, "version")

    groupId.text = arr[0]
    artifactId.text = arr[1]
    version.text = arr[2]

def addMockDep(tree):
    root = tree.findall(".//dependencies")[1]
    dep = ET.SubElement(root, "dependency")
    addArtifactElemen(dep, ['org.mockito', 'mockito-all', '1.9.5'])
    root = tree.findall(".//name")[0]
    root.text += "Mockito"

def redoDir(lst, idx, repl):
    del lst[idx]
    lst.insert(idx, repl)

def main():
	tree = None
	header="""<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">"""
	with open(sys.argv[1], encoding='utf-8') as f:
		xmlStr = f.readlines()
		redoDir(xmlStr, 0, """<?xml version="1.0" ?>""")
		redoDir(xmlStr, 1, header)
		xmlStr = clean("".join(xmlStr), header)
		tree = ET.fromstring(xmlStr)
		addMockDep(tree)

	xmlstr = MD.parseString(ET.tostring(tree)).toprettyxml(indent="   ")
	with open(sys.argv[1], "w") as f:
		xmlstr = xmlstr.replace('<root>', header).replace('</root>', '</project>')
		f.write(xmlstr)

if __name__ == '__main__':
    main()
