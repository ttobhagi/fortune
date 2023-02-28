function findToolsForBolt(boltType) {
  let toolList = [];

  switch (boltType) {
    case "Phillips":
      toolList.push({ name: "Phillips Screwdriver", sku: "12345", catalog: "https://example.com/catalog/12345" });
      break;
    case "Slotted":
      toolList.push({ name: "Slotted Screwdriver", sku: "67890", catalog: "https://example.com/catalog/67890" });
      break;
    case "Hex":
      toolList.push({ name: "Hex Key", sku: "24680", catalog: "https://example.com/catalog/24680" });
      break;
    default:
      console.log("Cannot find tools for this type of bolt.");
      break;
  }

  return toolList;
}

function runScript() {
  let boltType = "Phillips";
  let tools = findToolsForBolt(boltType);
  for (let i = 0; i < (tools).length; i++) {
  console.log(tools[i]);
  }

}
